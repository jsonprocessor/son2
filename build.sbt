enablePlugins(com.lucidchart.sbt.scalafmt.ScalafmtPlugin)

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

evictionWarningOptions in update := EvictionWarningOptions.default
  .withWarnTransitiveEvictions(false)
  .withWarnDirectEvictions(false)
  .withWarnScalaVersionEviction(false)

scapegoatVersion in ThisBuild := "1.3.4"
wartremoverErrors ++= Warts.unsafe

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-Ypartial-unification",
  "-Ywarn-unused-import",
  "-Xfatal-warnings",
  "-Xlint",
)

scalastyleFailOnWarning := true
scalastyleFailOnError := true

val JacksonVersion = "2.8.11"
val JacksonAnnotationVersion = JacksonVersion
val ScalaLibraryVersion = "2.12.4"
val ScalaticVersion = "3.0.4"
val ConfigVersion = "1.2.1"
val JunitVersion = "4.10"
val TestngVersion = "6.9.13.6"

val VersionSnapshot = s"$JacksonVersion-SNAPSHOT"

val commonSettings = Seq(
  organization := "pl.writeonly.scallions",
  scalaVersion := ScalaLibraryVersion,
  version := VersionSnapshot
)
val IntegrationTest = config("it") extend Test
val End2EndTest = config("et") extend Test

logBuffered in Test := false
testOptions in Test ++= Seq(
  Tests.Argument(TestFrameworks.ScalaTest, "-o"),
  Tests.Argument(TestFrameworks.ScalaTest, "-u", "target/test-reports"),
  Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/test-reports")
)

lazy val integrationInConfig = inConfig(IntegrationTest)(Defaults.testTasks)
lazy val end2endInConfig = inConfig(End2EndTest)(Defaults.testTasks)

def whiteFilter(name: String): Boolean = (name endsWith "AssertSpec") || (name endsWith "FutureSpec")
def grayFilter(name: String): Boolean = (name endsWith "ScalarSpec") || (name endsWith "VectorSpec")
def blackFilter(name: String): Boolean = (name endsWith "FunSpec") || (name endsWith "FeatureSpec")

lazy val whiteSetting = testOptions in Test := Seq(Tests.Filter(whiteFilter))
lazy val graySetting = testOptions in IntegrationTest := Seq(Tests.Filter(grayFilter))
lazy val blackSetting = testOptions in End2EndTest := Seq(Tests.Filter(blackFilter))

lazy val inConfigs = Seq(integrationInConfig, end2endInConfig)
lazy val settings = Seq(whiteSetting, graySetting, blackSetting)


lazy val scallions = (project in file("."))
//  .enablePlugins(JacocoItPlugin)
  .aggregate(clis, impl, core, subs, scallops)
  .dependsOn(specs, core, impl, subs, clis)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scalaons",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    coverageEnabled := true,
    coverageMinimum := 60,
    coverageFailOnMinimum := true
  )

lazy val clis = (project in file("scallions-clis"))
  .aggregate(copt, llop, rison, hocon, main)
  .dependsOn(copt, llop, subs)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-clis",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
    )
  )

lazy val copt = (project in file("scallions-clis/scallions-copt"))
  .dependsOn(specs, main)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-copt",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "com.github.scopt" %% "scopt" % "3.7.0",
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
    )
  )

lazy val llop = (project in file("scallions-clis/scallions-llop"))
  .dependsOn(main)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-llop",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.rogach" %% "scallop" % "3.1.1",
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
    )
  )

lazy val rison = (project in file("scallions-clis/scallions-rison"))
  .dependsOn(hocon, jackRison)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-rison",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % JacksonVersion,
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion

    )//,
    //    mainClass in assembly := Some("pl.writeonly.scallions.main.Main")
  )

lazy val hocon = (project in file("scallions-clis/scallions-hocon"))
  .dependsOn(main, jackHocon)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-hocon",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "com.fasterxml.jackson.module" %% "jackson-module-scala" % JacksonVersion,
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion
    )//,
    //    mainClass in assembly := Some("pl.writeonly.scallions.main.Main")
  )

lazy val main = (project in file("scallions-clis/scallions-main"))
  .dependsOn(specs, core, text, jack, path, patch, diff, json, impl)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-main",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    coverageMinimum := 60,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion
    )//,
    //    mainClass in assembly := Some("pl.writeonly.scallions.main.Main")
  )

lazy val impl = (project in file("scallions-impl"))
  .aggregate(text, jack, path, patch, diff, json)
  .dependsOn(specs, core, text, jack, path, patch, diff, json)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-impl",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion
    )
  )

lazy val json = (project in file("scallions-impl/scallions-json"))
  .dependsOn(specs, core, jack, path)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-json",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion
    )
  )

lazy val path = (project in file("scallions-impl/scallions-path"))
  .dependsOn(specs, core, jack)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-path",
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

lazy val jack = (project in file("scallions-impl/scallions-jack"))
  .dependsOn(specs, core)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-jack",
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

lazy val text = (project in file("scallions-impl/scallions-text"))
  .dependsOn(specs, core)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-text",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
      "org.apache.commons" % "commons-text" % "1.1",
      "org.unbescape" % "unbescape" % "1.1.5.RELEASE"
    )
  )

lazy val patch = (project in file("scallions-impl/scallions-patch"))
  .dependsOn(specs, core, jack)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-patch",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
      "com.github.fge" % "json-patch" % "1.9"
    )
  )

lazy val diff = (project in file("scallions-impl/scallions-diff"))
  .dependsOn(specs, core)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-diff",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
    )
  )

lazy val core = (project in file("scallions-core"))
  .aggregate(apis, funs)
  .dependsOn(specs, scallops, apis, funs)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-core",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
      "org.scalactic" %% "scalactic" % ScalaticVersion,
      "com.typesafe" % "config" % "1.3.2",
      "org.skyscreamer" % "jsonassert" % "1.5.0",
    )
  )

lazy val funs = (project in file("scallions-core/scallions-funs"))
  .dependsOn(specs, scallops, apis, ops)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-funs",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
      "org.scalactic" %% "scalactic" % ScalaticVersion,
      "org.skyscreamer" % "jsonassert" % "1.5.0"
    )
  )

lazy val apis = (project in file("scallions-core/scallions-apis"))
  .dependsOn(specs, scallops, pipe)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scallions-apis",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
      "org.scalactic" %% "scalactic" % ScalaticVersion,
      "com.fasterxml.jackson.core" % "jackson-annotations" % JacksonVersion,
      "com.typesafe" % "config" % "1.3.2",
    )
  )

lazy val subs = (project in file("son2-subs"))
  .aggregate(jackHocon,jackRison)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "addons",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    coverageEnabled := true,
    coverageMinimum := 60,
    coverageFailOnMinimum := true
  )

lazy val jackHocon = (project in file("son2-subs/jackson-dataformat-hocon"))
  .dependsOn()
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "jack-hocon",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "com.fasterxml.jackson.core" % "jackson-core" % JacksonVersion,
      "com.fasterxml.jackson.core" % "jackson-databind" % JacksonVersion,
      "com.fasterxml.jackson.core" % "jackson-annotations" % JacksonVersion,
      "com.typesafe" % "config" % ConfigVersion,
      "junit" % "junit" % JunitVersion % Test,
    )
  )

lazy val jackRison = (project in file("son2-subs/jackson-dataformat-rison"))
  .dependsOn()
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "jack-rison",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "com.fasterxml.jackson.core" % "jackson-core" % JacksonVersion,
      "com.fasterxml.jackson.core" % "jackson-databind" % JacksonVersion,
      "org.testng" % "testng" % TestngVersion % Test,
    )
  )


lazy val scallops = (project in file("scallions-adds"))
  //  .enablePlugins(JacocoItPlugin)
  .aggregate(specs)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "addons",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    coverageEnabled := true,
    coverageMinimum := 60,
    coverageFailOnMinimum := true
  )

lazy val ops = (project in file("scallions-adds/scala-ops"))
  .dependsOn(specs)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scala-ops",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
    )
  )

lazy val pipe = (project in file("scallions-adds/scala-pipe"))
  .dependsOn(specs)
  .configs(IntegrationTest, End2EndTest)
  .settings(
    name := "scala-pipe",
    commonSettings,
    integrationInConfig, end2endInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % ScalaLibraryVersion,
    )
  )

lazy val specs = (project in file("scallions-adds/scala-specs"))
  .settings(
    name := "scala-spec",
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
