name := """scala-session"""

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.2" % "test"

// Uncomment to use Akka
//libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.9"

fork in run := true

// from http://scalameter.github.io/home/download/
resolvers += "Sonatype OSS Snapshots" at
"https://oss.sonatype.org/content/repositories/releases"

libraryDependencies += "com.storm-enroute" %% "scalameter" % "0.6"

lazy val scalaMeterFramework = new TestFramework("org.scalameter.ScalaMeterFramework")

testFrameworks += scalaMeterFramework

parallelExecution in Test := false

testOptions in Test += Tests.Argument(scalaMeterFramework, "-silent")