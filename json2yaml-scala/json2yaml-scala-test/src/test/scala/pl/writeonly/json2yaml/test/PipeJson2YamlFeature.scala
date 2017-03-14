package pl.writeonly.json2yaml.test

import org.scalatest.{FeatureSpec, GivenWhenThen}

import sys.process._

class PipeJson2YamlFeature extends FeatureSpec with GivenWhenThen {

  val ONML = "java -jar ../json2yaml-scala-main/target/json2yaml-scala-main-2.8.3-SNAPSHOT.jar"
  val CAT = "cat"

  val outName = (name: String) =>  Features.outputPathname("pipe", name)

  feature("PipeJson2Yaml convert") {

    scenario("Apply one exclamation") {
      Given("converter FileJson2Yaml")
      val in = Features.inputPathname
      val file = ONML + " " + in + " " + outName("one")
      When("should produce null when consume null")
      val result = file.!
      Then("0 == result")
      assert(0 == result)
    }

    scenario("Apply two exclamation") {
      Given("converter FileJson2Yaml")
      val in = Features.inputPathname
      val file = ONML + " " + in + " " + outName("two")
      When("should produce null when consume null")
        val result = file.!!
      Then("0 == result")
      assert("" == result)    }
  }
}
