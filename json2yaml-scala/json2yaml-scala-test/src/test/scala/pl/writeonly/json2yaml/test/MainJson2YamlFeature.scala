package pl.writeonly.json2yaml.test

import java.io.{File, FileNotFoundException, FileOutputStream}
import java.nio.file.Paths

import org.scalatest.{FeatureSpec, GivenWhenThen}

import pl.writeonly.json2yaml.core._
import pl.writeonly.json2yaml.main._

class MainJson2YamlFeature extends FeatureSpec with GivenWhenThen {

  info("MainJson2YamlImpl with Json2YamlJackson")

  val given = () => new MainJson2Yaml(new FileJson2YamlImpl(new Json2YamlJackson))

  val NAME = "writeonly-init"
  val PREFIX = NAME + "."
  val PATH_LOG = "/" + PREFIX + "log"
  val YAML = MainJson2Yaml.YAML

  val outName = (name: String) => NAME + "main." + name + YAML

  feature("MainJson2Yaml with two pathname") {
    scenario("Apply with null pathname") {
      Given("converter FileJson2Yaml")
      val main = given()
      When("should produce null when consume null")
      val name: String = null
      val caught = intercept[NullPointerException] {
        main.convertFile(name, name)
      }
      Then("null == messag")
      val message = caught.getMessage
      assert(null == message)
    }

    scenario("Apply with empty pathname") {
      Given("converter FileJson2Yaml")
      val main = given()
      When("should produce empty when consume empty")
      assertThrows[FileNotFoundException] {
        main.convertFile("", "")
      }
    }

    scenario("Apply with pathname") {
      Given("converter FileJson2Yaml")
      val main = given()

      val resource = getClass.getResource(PATH_LOG).toURI
      val in = Paths.get(resource).toString
      val out = outName("pathname")

      When("should produce null when consume null")
      main.convertFile(in, out)
    }
  }

  feature("MainJson2Yaml with one pathname") {
    scenario("Apply with null pathname") {
      Given("converter FileJson2Yaml")
      val main = given()
      When("should produce null when consume null")
      val name: String = null
      val caught = intercept[NullPointerException] {
        main.convertFile(name)
      }
      Then("null == messag")
      val message = caught.getMessage
      assert(null == message)
    }

    scenario("Apply with empty pathname") {
      Given("converter FileJson2Yaml")
      val main = given()
      When("should produce null empty consume empty")
      assertThrows[FileNotFoundException] {
        main.convertFile("")
      }
    }

    scenario("Apply with pathname") {
      Given("converter FileJson2Yaml")
      val main = given()

      val resource = getClass.getResource(PATH_LOG).toURI
      val in = Paths.get(resource).toString
      val out = outName("pathname")

      When("should produce null when consume null")
      main.convertFile(in)
    }
  }

}

