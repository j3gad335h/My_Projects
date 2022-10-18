var express = require("express");
var path = require("path");
var routes = require("./routes");
var connection = require('./db');
var app = express();
// View Engine
app.set("views", path.join(__dirname, "views"));
app.set("view engine", "ejs");


app.set("port", process.env.PORT || 3000);

app.use(express.static("public"));
app.use(routes);

app.listen(app.get("port"), function(){
    console.log("Server started on port " + app.get("port"));
})