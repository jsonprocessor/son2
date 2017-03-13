package pl.writeonly.json2yaml.test

import java.nio.file.Paths

import org.scalatest.{FeatureSpec, GivenWhenThen}

import sys.process._

import pl.writeonly.json2yaml.main._

class PipeJson2YamlFeature extends FeatureSpec with GivenWhenThen {

  val NAME = "writeonly-init"
  val PREFIX = "yaml/"+ NAME + "."
  val PATH_LOG = "/" + PREFIX + "log"
  val YAML = MainJson2Yaml.YAML
  val ONML = "java -jar ../json2yaml-scala-main-2.8.3-SNAPSHOT.jar"
  val CAT = "cat"

  val outName = (name: String) => PREFIX + "pipe." + name + YAML

//  feature("PipeJson2Yaml convert") {
//    scenario("Apply with null pathname") {
//      Given("converter FileJson2Yaml")
//      val resource = getClass.getResource(PATH_LOG).toURI
//      val in = Paths.get(resource).toString
//      val file = CAT + " " + in + " | " + ONML + " > "  +outName("cat")
//      When("should produce null when consume null")
//      val result = file.!
//      Then("null == messag")
//      assert(null == result)
//    }
//  }
}
