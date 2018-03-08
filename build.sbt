enablePlugins(com.lucidchart.sbt.scalafmt.ScalafmtPlugin)

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

evictionWarningOptions in update := EvictionWarningOptions.default
  .withWarnTransitiveEvictions(false)
  .withWarnDirectEvictions(false)
  .withWarnScalaVersionEviction(false)

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-Ywarn-unused-import",
  "-Xfatal-warnings",
)

val JacksonVersion = "2.8.11"
val ScalaLibraryVersion = "2.12.4"

lazy val versionSnapshot = s"$JacksonVersion-SNAPSHOT"

lazy val commonSettings = Seq(
  organization := "pl.writeonly.son2",
  scalaVersion := ScalaLibraryVersion,
  version := versionSnapshot
)
lazy val IntegrationTest = config("it") extend(Test)
lazy val End2EndTest = config("et") extend(Test)

lazy val integrationInConfig = inConfig(IntegrationTest)(Defaults.testTasks)
lazy val end2endInConfig = inConfig(End2EndTest)(Defaults.testTasks)

def whiteFilter(name: String): Boolean = name endsWith "AssertSpec"
def grayFilter(name: String): Boolean = (name endsWith "ScalarSpec") || (name endsWith "VectorSpec")
def blackFilter(name: String): Boolean = (name endsWith "FunSpec") || (name endsWith "FeatureSpec")

lazy val whiteSetting = testOptions in Test := Seq(Tests.Filter(whiteFilter))
lazy val graySetting = testOptions in IntegrationTest := Seq(Tests.Filter(grayFilter))
lazy val blackSetting = testOptions in End2EndTest := Seq(Tests.Filter(blackFilter))

lazy val inConfigs = Seq(integrationInConfig, end2endInConfig)
lazy val settings = Seq(whiteSetting, graySetting, blackSetting)

lazy val son2 = (project in file("."))
//  .enablePlugins(JacocoItPlugin)
  .aggregate(spec, core, impl, main, clis)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "son2",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    coverageEnabled := true,
    coverageMinimum := 60,
    coverageFailOnMinimum := true
  )

lazy val clis = (project in file("son2-clis"))
  .dependsOn(copt, llop)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "son2-clis",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
    )
  )

lazy val copt = (project in file("son2-clis/son2-copt"))
  .dependsOn(spec, main)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "son2-copt",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "com.github.scopt" %% "scopt" % "3.7.0",
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
    )
  )

lazy val llop = (project in file("son2-clis/son2-llop"))
  .dependsOn(main)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "son2-llop",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.rogach" %% "scallop" % "3.1.1",
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
    )
  )

lazy val main = (project in file("son2-main"))
  .dependsOn(spec, core, text, jack, path, patch, diff, json, impl)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "son2-main",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion
    )//,
    //    mainClass in assembly := Some("pl.writeonly.son2.main.Main")
  )

lazy val impl = (project in file("son2-impl"))
  .aggregate(text, jack, path, patch, diff, json)
  .dependsOn(spec, core, text, jack, path, patch, diff, json)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "son2-impl",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion
    )
  )

lazy val json = (project in file("son2-impl/son2-json"))
  .dependsOn(spec, core, jack, path)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "son2-json",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion
    )
  )

lazy val path = (project in file("son2-impl/son2-path"))
  .dependsOn(spec, core, jack)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "son2-path",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
      "com.jayway.jsonpath" % "json-path" % "2.4.0",
      "net.minidev" % "json-smart" % "2.3",
      "com.google.code.gson" % "gson" % "2.8.1",
      "org.apache.tapestry" % "tapestry-json" % "5.4.3",
      "org.codehaus.jettison" % "jettison" % "1.3.8",
      //      "org.json" % "json" % "20170516"
      "com.vaadin.external.google" % "android-json" % "0.0.20131108.vaadin1"
    )
  )

lazy val jack = (project in file("son2-impl/son2-jack"))
  .dependsOn(spec, core)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "son2-jack",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
      "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % JacksonVersion,
      "com.fasterxml.jackson.dataformat" % "jackson-dataformat-xml" % JacksonVersion,
      "com.fasterxml.jackson.dataformat" % "jackson-dataformat-properties" % JacksonVersion,
      "com.fasterxml.jackson.dataformat" % "jackson-dataformat-csv" % JacksonVersion,
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % JacksonVersion,
      "ninja.leaping.configurate" % "configurate-hocon" % "3.2"
    )
  )

lazy val text = (project in file("son2-impl/son2-text"))
  .dependsOn(spec, core)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "son2-text",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
      "org.apache.commons" % "commons-text" % "1.1",
      "org.unbescape" % "unbescape" % "1.1.5.RELEASE"
    )
  )

lazy val patch = (project in file("son2-impl/son2-patch"))
  .dependsOn(spec, core, jack)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "son2-patch",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
      "com.github.fge" % "json-patch" % "1.9"
    )
  )

lazy val diff = (project in file("son2-impl/son2-diff"))
  .dependsOn(spec, core)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "son2-diff",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
    )
  )

lazy val core = (project in file("son2-core"))
  .dependsOn(spec)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "son2-core",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
      "org.scalactic" %% "scalactic" % "3.0.4",
      "com.typesafe" % "config" % "1.3.2",
      "com.google.guava" % "guava" % "23.0",
      "org.skyscreamer" % "jsonassert" % "1.5.0"
    )
  )

lazy val spec = (project in file("son2-spec"))
  .settings(
    name := "son2-spec",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
      "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
      "org.scalamock" %% "scalamock-scalatest-support" % "3.6.0",
      "org.scalacheck" %% "scalacheck" % "1.13.5",
      "org.pegdown" % "pegdown" % "1.6.0",
      "ch.qos.logback" % "logback-classic" % "1.2.3"
    )
  )