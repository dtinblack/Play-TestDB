// app.js - application using Nodejs to access the database
// Need to install MongoJS: npm install mongojs

var databaseURL = "TestDB";
var collections = ["quotes"];
var db = require("mongojs").connect(databaseURL, collections);

db.quotes.find(function(err, docs) {
     console.log(docs);
}); 
