val scala3Version = "3.4.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "count-the-islands",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio" % "2.1.1",
      "dev.zio" %% "zio-streams" % "2.1.1",
      "org.scalameta" %% "munit" % "1.0.0" % Test,
      "org.scalameta" %% "munit-scalacheck" % "1.0.0" % Test
    )
  )
