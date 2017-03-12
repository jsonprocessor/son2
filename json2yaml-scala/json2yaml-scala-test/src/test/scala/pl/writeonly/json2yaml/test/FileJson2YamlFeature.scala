package pl.writeonly.json2yaml.test

import java.nio.file.Paths

import org.scalatest.{FeatureSpec, GivenWhenThen}
import org.scalatest.Assertions._

import pl.writeonly.json2yaml.core.FileJson2Yaml
import pl.writeonly.json2yaml.core.FileJson2YamlImpl
import pl.writeonly.json2yaml.core.Json2YamlJackson


class FileJson2YamlFeature extends FeatureSpec with GivenWhenThen {

  info("FileJson2YamlImpl with Json2YamlJackson")

  feature("Json2Yaml convert") {
    scenario("Convert null pathname") {
      Given("converter FileJson2Yaml")
      var onml: FileJson2Yaml = new FileJson2YamlImpl(new Json2YamlJackson())
//
      When("should produce null when consume null")
//      val caught = assertThrows[NullPointerException] {
      val name:String = null
      val caught = intercept[NullPointerException] {
        onml.convertFile(name, name)
      }
//
      Then("the TV should switch on")
      val message = caught.getMessage
      assert(null == message)
    }

    scenario("User presses power button when TV is on") {
      Given("a TV set that is switched on")
      var onml: FileJson2Yaml = new FileJson2YamlImpl(new Json2YamlJackson())

      When("should produce null when consume null")
//      onml.convertFile("", "")
      Then("the TV should switch off")
    }

    scenario("User presses power button when TV is on2") {
      Given("a TV set that is switched on")
      var onml: FileJson2Yaml = new FileJson2YamlImpl(new Json2YamlJackson())
      val name = "writeonly-init"
      val resource = getClass.getResource("/"+name+".log").toURI
      val pathname = Paths.get(resource).toString
//
      When("should produce null when consume null")
//      onml.convertFile(pathname, name + ".yaml")
      Then("the TV should switch off")
////      assert("" == message, message)
    }
  }
}

