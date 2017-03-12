package pl.writeonly.json2yaml.test

import java.io.{File, FileNotFoundException, FileOutputStream}
import java.nio.file.Paths

import org.scalatest.{FeatureSpec, GivenWhenThen}

import pl.writeonly.json2yaml.core._
import pl.writeonly.json2yaml.main._

class FileJson2YamlFeature extends FeatureSpec with GivenWhenThen {

  info("FileJson2YamlImpl with Json2YamlJackson")

  feature("Json2Yaml convert") {
    scenario("Apply with null pathname") {
      Given("converter FileJson2Yaml")
      var onml: FileJson2Yaml = new FileJson2YamlImpl(new Json2YamlJackson())
      When("should produce null when consume null")
      val name: String = null
      val caught = intercept[NullPointerException] {
        onml.convertFile(name, name)
      }
      Then("null == messag")
      val message = caught.getMessage
      assert(null == message)
    }

    scenario("Apply with empty pathname") {
      Given("converter FileJson2Yaml")
      var onml: FileJson2Yaml = new FileJson2YamlImpl(new Json2YamlJackson())

      When("should produce null when consume null")
      assertThrows[FileNotFoundException] {
        onml.convertFile("", "")
      }
    }

    val NAME = "writeonly-init"
    val PREFIX = NAME + "."
    val PATH_LOG = "/" + PREFIX + "log"
    val YAML = MainJson2Yaml.YAML

    val outName = (name: String) => NAME + name + YAML

    scenario("Apply with pathname") {
      Given("converter FileJson2Yaml")
      var onml: FileJson2Yaml = new FileJson2YamlImpl(new Json2YamlJackson())

      val resource = getClass.getResource(PATH_LOG).toURI
      val in = Paths.get(resource).toString
      val out = outName("pathname")

      When("should produce null when consume null")
      onml.convertFile(in, out)
    }

    scenario("Apply with uri") {
      Given("converter FileJson2Yaml")
      var onml: FileJson2Yaml = new FileJson2YamlImpl(new Json2YamlJackson())

      val in = getClass.getResource(PATH_LOG).toURI
      val out = new File(outName("uri")).toURI

      When("should produce null when consume null")
      onml.convertFile(in, out)
    }

    scenario("Apply with file") {
      Given("converter FileJson2Yaml")
      var onml: FileJson2Yaml = new FileJson2YamlImpl(new Json2YamlJackson())

      val in = new File(getClass.getResource(PATH_LOG).toURI)
      val out = new File(outName("file"))

      When("should produce null when consume null")
      onml.convertFile(in, out)
    }

    scenario("Apply with stream") {
      Given("converter FileJson2Yaml")
      var onml: FileJson2Yaml = new FileJson2YamlImpl(new Json2YamlJackson())
      val in = getClass.getResourceAsStream(PATH_LOG)
      val out = new FileOutputStream(outName("stream"))

      When("should produce null when consume null")
      onml.convertStream(in, out)
    }

  }
}

