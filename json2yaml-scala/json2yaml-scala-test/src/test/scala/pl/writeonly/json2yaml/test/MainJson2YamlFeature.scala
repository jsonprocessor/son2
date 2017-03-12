package pl.writeonly.json2yaml.test

import java.io.{File, FileNotFoundException, FileOutputStream}
import java.nio.file.Paths

import org.scalatest.{FeatureSpec, GivenWhenThen}

import pl.writeonly.json2yaml.core._
import pl.writeonly.json2yaml.main._

class MainJson2YamlFeature extends FeatureSpec with GivenWhenThen {

  info("MainJson2YamlImpl with Json2YamlJackson")

  val given = () => new MainJson2Yaml(new FileJson2YamlImpl(new Json2YamlJackson))

  feature("Json2Yaml convert") {
    scenario("Apply with null pathname") {
      Given("converter FileJson2Yaml")
      var main: given()
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
      var main: MainJson2Yaml = new MainJson2Yaml(new FileJson2YamlImpl(new Json2YamlJackson))
      When("should produce null when consume null")
      assertThrows[FileNotFoundException] {
        main.convertFile("", "")
      }
    }

    val NAME = "writeonly-init"
    val PREFIX = NAME + "."
    val PATH_LOG = "/" + PREFIX + "log"
    val YAML = MainJson2Yaml.YAML

    val outName = (name: String) => NAME + name + YAML

    scenario("Apply with pathname") {
      Given("converter FileJson2Yaml")
      var main: MainJson2Yaml = new MainJson2Yaml(new FileJson2YamlImpl(new Json2YamlJackson))

      val resource = getClass.getResource(PATH_LOG).toURI
      val pathname = Paths.get(resource).toString

      When("should produce null when consume null")
      main.convertFile(pathname, outName("pathname"))
    }
  }
}

