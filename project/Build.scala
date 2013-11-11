import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "todoPlay"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "com.github.twitter" % "bootstrap" % "2.0.2",
    "com.novus" %% "salat" % "1.9.5-SNAPSHOT",
    jdbc,
    anorm
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
      
      resolvers ++= Seq(
           "webjars" at "http://webjars.github.com/m2", 
           "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
      )     
  )

}