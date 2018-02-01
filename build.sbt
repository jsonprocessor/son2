enablePlugins(com.lucidchart.sbt.scalafmt.ScalafmtPlugin)

lazy val dropwizardVersion = "1.1.4"
lazy val jacksonVersion = "2.8.3"
lazy val vaadinVersion = "8.1.2"

lazy val versionSnapshot = "2.8.3-SNAPSHOT"

lazy val commonSettings = Seq(
  organization := "pl.writeonly.son2",
  scalaVersion := "2.11.8",
  version := versionSnapshot
)
//lazy val FunJacoco = config("fun") extend(JacocoItPlugin)
lazy val FunTest = config("fun") extend(Test)
lazy val FeatureTest = config("feature") extend(Test)

lazy val funInConfig = inConfig(FunTest)(Defaults.testTasks)
lazy val featureInConfig = inConfig(FeatureTest)(Defaults.testTasks)

def whiteFilter(name: String): Boolean = (name endsWith "ResultSpec") || (name endsWith "ThrowsSpec")
def grayFilter(name: String): Boolean = (name endsWith "ScalarSpec") || (name endsWith "VectorSpec ")
def blackFilter(name: String): Boolean = (name endsWith "FeatureSpec")

lazy val whiteSetting = testOptions in Test := Seq(Tests.Filter(whiteFilter))
lazy val graySetting = testOptions in FunTest := Seq(Tests.Filter(grayFilter))
lazy val blackSetting = testOptions in FeatureTest := Seq(Tests.Filter(blackFilter))

lazy val inConfigs = Seq(funInConfig, featureInConfig)
lazy val settings = Seq(whiteSetting, graySetting, blackSetting)


lazy val son2 = (project in file("."))
//  .enablePlugins(JacocoItPlugin)
  .aggregate(spec, core, impl, main, drop)
  .configs(FunTest, FeatureTest)
  .settings(
    name := "son2",
    commonSettings,
    funInConfig, featureInConfig,
    whiteSetting, graySetting, blackSetting,
    coverageEnabled := true,
    coverageMinimum := 60,
    coverageFailOnMinimum := true
//    jacocoAggregateReportSettings := JacocoReportSettings()
//      .withThresholds(
//        JacocoThresholds(
//          instruction = 8,
//          method = 10,
//          branch = 10,
//          complexity = 10,
//          line = 9,
//          clazz = 10)
//      )

  )

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
    )//,
//    assemblyJarName in assembly := "son2-spec.jar"//,
//    jacocoReportSettings := JacocoReportSettings()
//      .withThresholds(
//        JacocoThresholds(
//          instruction = 0,
//          method = 0,
//          branch = 0,
//          complexity = 0,
//          line = 0,
//          clazz = 0)
//      )
  )

lazy val core = (project in file("son2-core"))
  .dependsOn(spec)
  .configs(FunTest, FeatureTest)
  .settings(
    name := "son2-core",
    commonSettings,
    funInConfig, featureInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "org.scala-lang" % "scala-library" % "2.11.11",
      "org.scalactic" % "scalactic_2.11" % "3.0.4",
      "com.google.guava" % "guava" % "23.0",
      "org.skyscreamer" % "jsonassert" % "1.5.0"
    )
  )

lazy val text = (project in file("son2-impl/son2-text"))
  .dependsOn(spec, core)
  .configs(FunTest, FeatureTest)
  .settings(
    name := "son2-text",
    commonSettings,
    libraryDependencies ++= Seq(
      "org.apache.commons" % "commons-text" % "1.1",
      "org.unbescape" % "unbescape" % "1.1.5.RELEASE"
    )
  )

lazy val jack = (project in file("son2-impl/son2-jack"))
  .dependsOn(spec, core)
  .configs(FunTest, FeatureTest)
  .settings(
    name := "son2-jack",
    commonSettings,
    funInConfig, featureInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % jacksonVersion,
      "com.fasterxml.jackson.dataformat" % "jackson-dataformat-xml" % jacksonVersion,
      "com.fasterxml.jackson.dataformat" % "jackson-dataformat-properties" % jacksonVersion,
      "com.fasterxml.jackson.dataformat" % "jackson-dataformat-csv" % jacksonVersion,
      "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % jacksonVersion,
      "ninja.leaping.configurate" % "configurate-hocon" % "3.2"
    )
  )

lazy val path = (project in file("son2-impl/son2-path"))
  .dependsOn(spec, core, jack)
  .configs(FunTest, FeatureTest)
  .settings(
    name := "son2-path",
    commonSettings,
    funInConfig, featureInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "com.jayway.jsonpath" % "json-path" % "2.4.0",
      "net.minidev" % "json-smart" % "2.3",
      "com.google.code.gson" % "gson" % "2.8.1",
      "org.apache.tapestry" % "tapestry-json" % "5.4.3",
      "org.codehaus.jettison" % "jettison" % "1.3.8",
//      "org.json" % "json" % "20170516"
      "com.vaadin.external.google" % "android-json" % "0.0.20131108.vaadin1"
    )
  )


lazy val patch = (project in file("son2-impl/son2-patch"))
  .dependsOn(spec, core, jack)
  .configs(FunTest, FeatureTest)
  .settings(
    name := "son2-patch",
    commonSettings,
    funInConfig, featureInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "com.github.fge" % "json-patch" % "1.9"
    )
  )

lazy val diff = (project in file("son2-impl/son2-diff"))
  .dependsOn(spec, core)
  .configs(FunTest, FeatureTest)
  .settings(
    name := "son2-diff",
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val json = (project in file("son2-impl/son2-json"))
  .dependsOn(spec, core, jack, path)
  .configs(FunTest, FeatureTest)
  .settings(
    name := "son2-json",
    commonSettings,
    libraryDependencies ++= Seq(
    )
  )

lazy val impl = (project in file("son2-impl"))
  .aggregate(text, jack, path, patch, diff, json)
  .dependsOn(spec, core, text, jack, path, patch, diff, json)
  .configs(FunTest, FeatureTest)
  .settings(
    name := "son2-impl",
    commonSettings,
    funInConfig, featureInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
    )
  )

lazy val main = (project in file("son2-main"))
  .dependsOn(spec, core, text, jack, path, patch, diff, json, impl)
  .configs(FunTest, FeatureTest)
  .settings(
    name := "son2-main",
    commonSettings,
    funInConfig, featureInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
    )//,
//    mainClass in assembly := Some("pl.writeonly.son2.main.Main")
  )




lazy val adin = (project in file("son2-adin"))
  .dependsOn(spec, core, json)
  .configs(FunTest, FeatureTest)
  .settings(
    name := "son2-adin",
    commonSettings,
    funInConfig, featureInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "com.vaadin" % "vaadin-themes" % vaadinVersion,
      "com.vaadin" % "vaadin-client-compiled" % vaadinVersion,
      "com.vaadin" % "vaadin-server" % vaadinVersion,
      "javax.servlet" % "javax.servlet-api" % "4.0.0" % "provided"
    )
  )

lazy val view = (project in file("son2-view"))
  .configs(FunTest, FeatureTest)
  .settings(
    name := "son2-view",
    commonSettings,
    funInConfig, featureInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
    )
  )

lazy val drop = (project in file("son2-drop"))
  .dependsOn(spec, core, adin)
  .configs(FunTest, FeatureTest)
  .settings(
    name := "son2-drop",
    commonSettings,
    funInConfig, featureInConfig,
    whiteSetting, graySetting, blackSetting,
    libraryDependencies ++= Seq(
      "io.dropwizard" % "dropwizard-core" % dropwizardVersion,
      "io.dropwizard" % "dropwizard-assets" % dropwizardVersion
    ),
    mainClass in assembly := Some("pl.writeonly.son2.drop.AppSon2")
  )

