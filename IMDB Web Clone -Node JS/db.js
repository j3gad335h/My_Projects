
const mysql = require('mysql');
const mydb = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'flask-test'
});

// Connect to mysql
mydb.connect((err) => {
    if (err) {
        throw err;
    }
    console.log("mysql connected")
});

module.exports = mydb;