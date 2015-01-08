name := "scala-modules"

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "2.4.15" % "test",
  "org.scalaz" %% "scalaz-core" % "7.1.0",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.1"
)
