//sbt.version = 1.0.2

lazy val dropwizardVersion = "1.1.4"
lazy val jacksonVersion = "2.8.3"
lazy val vaadinVersion = "8.1.2"

lazy val versionSnapshot = "2.8.3-SNAPSHOT"

lazy val commonSettings = Seq(
  organization := "pl.writeonly.son2",
  scalaVersion := "2.11.8",
  version := versionSnapshot
)

lazy val son2 = (project in file("."))
  .settings(
    name := "son2",
    commonSettings
  )
  .aggregate(spec, core, impl, main, drop)

lazy val spec = (project in file("son2-spec"))
  .settings(
    name := "son2-spec",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % "2.11.11",
      "com.typesafe.scala-logging" % "scala-logging_2.11" % "3.7.2",
      "org.scalamock" % "scalamock-scalatest-support_2.11" % "3.6.0",
      "org.scalacheck" % "scalacheck_2.11" % "1.13.5",
      "org.pegdown" % "pegdown" % "1.6.0",
      "ch.qos.logback" % "logback-classic" % "1.2.3"
    )
  )

lazy val core = (project in file("son2-core"))
  .settings(
    name := "son2-core",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % "2.11.11",
      "org.scalactic" % "scalactic_2.11" % "3.0.4",
      "com.google.guava" % "guava" % "23.0",
      "org.skyscreamer" % "jsonassert" % "1.5.0"
    )
  )
  .dependsOn(spec)

lazy val text = (project in file("son2-impl/son2-text"))
  .settings(
    name := "son2-text",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.apache.commons" % "commons-text" % "1.1",
      "org.unbescape" % "unbescape" % "1.1.5.RELEASE"
    )
  )
  .dependsOn(spec, core)

lazy val jack = (project in file("son2-impl/son2-jack"))
  .settings(
    name := "son2-jack",
    commonSettings,
    libraryDependencies ++= Seq(
      "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % jacksonVersion,
      "com.fasterxml.jackson.dataformat" % "jackson-dataformat-xml" % jacksonVersion,
      "com.fasterxml.jackson.dataformat" % "jackson-dataformat-properties" % jacksonVersion,
      "com.fasterxml.jackson.dataformat" % "jackson-dataformat-csv" % jacksonVersion,
      "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % jacksonVersion,
      "ninja.leaping.configurate" % "configurate-hocon" % "3.2"
    )
  )
  .dependsOn(spec, core)

lazy val path = (project in file("son2-impl/son2-path"))
  .settings(
    name := "son2-path",
    commonSettings,
    libraryDependencies ++= Seq(
      "com.jayway.jsonpath" % "json-path" % "2.4.0",
      "net.minidev" % "json-smart" % "2.3",
      "com.google.code.gson" % "gson" % "2.8.1",
      "org.apache.tapestry" % "tapestry-json" % "5.4.3",
      "org.codehaus.jettison" % "jettison" % "1.3.8",
      "org.json" % "json" % "20170516"
    )
  )
  .dependsOn(spec, core, jack)


lazy val patch = (project in file("son2-impl/son2-patch"))
  .settings(
    name := "son2-patch",
    commonSettings,
    libraryDependencies ++= Seq(
      "com.github.fge" % "json-patch" % "1.9"
    )
  )
  .dependsOn(spec, core, jack)

lazy val diff = (project in file("son2-impl/son2-diff"))
  .settings(
    name := "son2-diff",
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )
  .dependsOn(spec, core)

lazy val json = (project in file("son2-impl/son2-json"))
  .settings(
    name := "son2-json",
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )
  .dependsOn(spec, core, jack, path)

lazy val impl = (project in file("son2-impl"))
  .settings(
    name := "son2-impl",
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )
  .aggregate(text, jack, path, patch, diff, json)
  .dependsOn(spec, core, text, jack, path, patch, diff, json)

lazy val main = (project in file("son2-main"))
  .settings(
    name := "son2-main",
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )
  .dependsOn(spec, core, text, jack, path, patch, diff, json, impl)



lazy val adin = (project in file("son2-adin"))
  .settings(
    name := "son2-adin",
    commonSettings,
    libraryDependencies ++= Seq(
      "com.vaadin" % "vaadin-themes" % vaadinVersion,
      "com.vaadin" % "vaadin-client-compiled" % vaadinVersion,
      "com.vaadin" % "vaadin-server" % vaadinVersion,
      "javax.servlet" % "javax.servlet-api" % "4.0.0" % "provided"
    )
  )
  .dependsOn(spec, core, json)

lazy val view = (project in file("son2-view"))
  .settings(
    name := "son2-view",
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val drop = (project in file("son2-drop"))
  .settings(
    name := "son2-drop",
    commonSettings,
    libraryDependencies ++= Seq(
      "io.dropwizard" % "dropwizard-core" % dropwizardVersion,
      "io.dropwizard" % "dropwizard-assets" % dropwizardVersion
    )
  )
  .dependsOn(spec, core, adin)

