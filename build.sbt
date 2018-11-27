name := "Cognotekt Scala Code Test"

version := "1.0"

lazy val validator = (project in file("."))
  .settings(
    scalaVersion := "2.12.7",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.4" % "test"
    )
  )
