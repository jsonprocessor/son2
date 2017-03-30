package pl.writeonly.son2.test

import java.io.FileNotFoundException

import org.scalatest.{FeatureSpec, GivenWhenThen}
import pl.writeonly.son2.impl.core.providers.ProviderYaml
import pl.writeonly.son2.impl.core.streamers.StreamerImpl

class StreamerYamlFeature extends FeatureSpec with GivenWhenThen {

  info("StreamerImpl with ProviderYaml")

  val given = () => new StreamerImpl(new ProviderYaml)

  val outName = (name: String) => Features.outputPathname("streamer", name, "yaml")

  feature(classOf[StreamerYamlFeature].getSimpleName) {
    scenario("Apply with null pathname") {
      Given("converter FileJson2Yaml")
      val file = given()
      val name: String = null

      When("should produce null when consume null")
      val caught = intercept[NullPointerException] {
        file.convertFile(name, name)
      }

      Then("null == messag")
      val message = caught.getMessage
      assert(null == message)
    }

    scenario("Apply with empty pathname") {
      Given("converter FileJson2Yaml")
      val file = given()

      When("should produce empty when consume empty")
      assertThrows[FileNotFoundException] {
        file.convertFile("", "")
      }
    }

    scenario("Apply with pathname") {
      Given("converter FileJson2Yaml")
      val file = given()
      val in = Features.inputPathname
      val out = outName("pathname")

      When("should produce null when consume null")
      file.convertFile(in, out)
    }

    scenario("Apply with uri") {
      Given("converter FileJson2Yaml")
      val file = given()
      val in = Features.inputURI
      val out = Features.toURI(outName("uri"))

      When("should produce null when consume null")
      file.convertFile(in, out)
    }

    scenario("Apply with file") {
      Given("converter FileJson2Yaml")
      val file = given()
      val in = Features.inputFile
      val out = Features.toFile(outName("file"))

      When("should produce out when consume in")
      file.convertFile(in, out)
    }
  }
}

