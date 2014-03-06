# Integrating the Play Framework with MongoDB

Using some examples from the web ( see Thanks below ) to integrate [MongoDB] ( http://www.mongodb.org/ ) into the 
[Play Framework] (http://www.playframework.com/ ) using [SalatDAO] ( https://github.com/novus/salat/wiki/SalatDAO ). 

# Software
 
* Operating System : Mac OS 10.9 ( Mavericks )
* Play Framework : v0.13.0
* MongoDB: v2.4.7 

# Installing and Running

After installing from GitHub:

    play clean-all 
    play compile

To run:

    play run  

and start the database:

    mongod -dbpath /<Folder Name>/data

# Thanks

To the Team behind [ ScalaIDE for Eclipse ] ( http://scala-ide.org/docs/tutorials/play/ ), 
James Hughes' Blog [Starter for 10 - Scala, Play 2 and Mongo](http://yobriefca.se/blog/2012/05/08/starter-for-10-scala-play-2-and-mongo/), 
and Rose Tommey for [SalatDAO] ( https://github.com/novus/salat/wiki/SalatDAO ).

# Licence

[See licence]( https://github.com/dtinblack/Play-TestDB/blob/master/LICENSE ) 

