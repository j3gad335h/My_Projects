
var express = require("express");
var router = express.Router();
var axios = require('axios');

const mysql = require('mysql');
const mydb = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'flask-test'
});

function createConnection() {
    const mydb = mysql.createConnection({
        host: 'localhost',
        user: 'root',
        password: '',
        database: 'flask-test'
    });
    return mydb;
}
router.get("/", function (req, res) {
    // console.log("hello I'm on the start page");
    res.render("index");
});


router.get("/info", function (req, res) {
    let id = req.query.id;
    console.log(id);
    var url = `https://api.themoviedb.org/3/movie/${id}?api_key=5fcb0aa099a1ba810aa4837005668050&language=en-US`;
    let info = {};
    axios.get(url)
        .then(response => {
            var result = JSON.parse(JSON.stringify(response.data))
            info['title'] = result['title'];
            try {
                if (result['poster_path'].length > 5) {
                    info['poster'] = "https://image.tmdb.org/t/p/original/" + result['poster_path'];
                }
            } catch (err) {
                info['poster'] = "";
            }

            info['genres'] = result['genres'];
            info['tmdb_id']=id;
            var plot = result['overview'].replaceAll('"', '');
            info['overview'] = plot;
            info['imdb_id'] = result['imdb_id'];
            info['release_date'] = result['release_date'];
            info['runtime'] = result['runtime'];
            let promises = [];
            var crew_url = `https://api.themoviedb.org/3/movie/${id}/credits?api_key=5fcb0aa099a1ba810aa4837005668050&language=en-US`;
            promises.push(
                axios.get(crew_url)
                    .then(response2 => {
                        var result2 = JSON.parse(JSON.stringify(response2.data));
                        let loop = 1;
                        let actor = [];
                        let director = [];
                        let writer = []
                        for (var v = 0; v < result2['cast'].length; v++) {
                            if (result2['cast'][v]['known_for_department'] == 'Acting' && loop < 4) {
                                actor.push(result2['cast'][v]['name']);
                                loop++;
                            }
                        }
                        let dir_loop = 1
                        let wri_loop = 1
                        for (var v = 0; v < result2['crew'].length; v++) {

                            if (result2['crew'][v]['job'] == 'Director' && dir_loop < 4) {
                                director.push(result2['crew'][v]['name']);
                                dir_loop++;
                            }
                            else if (result2['crew'][v]['job'] == 'Screenplay' || result2['crew'][v]['job'] == 'Writer' && wri_loop < 4) {
                                writer.push(result2['crew'][v]['name']);
                                wri_loop++;
                            }
                        }
                        info['writer'] = writer;
                        info['director'] = director;
                        info['actor'] = actor;
                    })
            )
            var vid_url = `https://api.themoviedb.org/3/movie/${id}/videos?api_key=5fcb0aa099a1ba810aa4837005668050&language=en-US`;
            let tra_promise = [];
            promises.push(
                axios.get(vid_url)
                    .then(response3 => {
                        var result3 = JSON.parse(JSON.stringify(response3.data));
                        let item = 0;
                        for (var v = 0; v < result3['results'].length; v++) {
                            if (result3['results'][v]['type'] == 'Trailer') {
                                info['trailer'] = 'https://www.youtube.com/embed/' + result3['results'][v]['key'] + '?list=RDD3O6nOrI5Ug';
                                item = 1;
                                break;
                            }
                        } try {
                            if (item != 1) {
                                try {
                                    info['trailer'] = 'https://www.youtube.com/embed/' + result3['results'][0]['key'] + '?list=RDD3O6nOrI5Ug';
                                } catch (e) {
                                    tra_promise.push(
                                        axios.get(`https://imdb-api.com/en/API/Trailer/k_l98p8ipa/${result['imdb_id']}`))
                                        .then(trailer => {
                                            var tra_res = JSON.parse(JSON.stringify(trailer.data));
                                            info['trailer'] = tra_res['linkEmbed'];
                                        })
                                }
                            }
                        } catch (err) {
                            console.log("No video Found")
                        }

                    })
            )
            Promise.all(promises).then(() => {
                const mydb1 = createConnection();
                let query1 = `Select ib_imdbid from imdb where ib_imdbid="5465464"`;
                try {
                    let sql = `INSERT INTO imdb (ib_imdbid,ib_tmdbid,ib_moviename,ib_plot,ib_reldate,ib_runtime,
                        ib_directors,ib_writers,ib_stars,ib_genres,ib_poster,ib_trailer)
                    VALUES("${info['imdb_id']}","${info['tmdb_id']}","${info['title']}","${info['overview']}","${info['release_date']}","${info['runtime']}",
                    "${info['director']}","${info['writer']}","${info['actor']}","${info['genres']}","${info['poster']}","${info['trailer']}")`;
                    mydb1.query(sql, function (err, result) {
                        if (err) throw err;
                        mydb1.end();
                    });
                } catch (err) {
                    console.log(err)
                }
                res.render('info', { page_title: "Info Page", data: info })
            })

        });
});

// Select Value
router.get("/movies", function (req, res) {
    let sql = "Select * from imdb";
    mydb.query(sql, function (err, result) {
        if (err) throw err;
        result = JSON.parse(JSON.stringify(result));
        res.render('movies', { page_title: "Movies Page", data: result })
        mydb.end();
    });
});

// Results route
router.get("/result", function (req, res) {
    let query = req.query.search;
    axios.get(`https://api.themoviedb.org/3/search/movie?api_key=5fcb0aa099a1ba810aa4837005668050&language=en-US&query=${query}&page=1&include_adult=false`)
        .then(response => {
            var result = JSON.parse(JSON.stringify(response.data))
            let promises = [];
            for (let i = 2; i <= result['total_pages']; i++) {
                promises.push(
                    axios.get(`https://api.themoviedb.org/3/search/movie?api_key=5fcb0aa099a1ba810aa4837005668050&language=en-US&query=${query}&page=${i}&include_adult=false`)
                        .then(response2 => {
                            var result2 = JSON.parse(JSON.stringify(response2.data));
                            result['results'] = result['results'].concat(result2["results"]);
                        })
                )
            }
            Promise.all(promises).then(() => {
                res.render('result', { page_title: "Result Page", data: result })
            })
        });
});

module.exports = router;