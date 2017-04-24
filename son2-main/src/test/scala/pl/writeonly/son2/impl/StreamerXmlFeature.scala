package pl.writeonly.son2.impl

import java.io.FileNotFoundException

import org.scalatest.{FeatureSpec, GivenWhenThen}
import pl.writeonly.son2.core.core.Formats
import pl.writeonly.son2.core.formats.FormatProvider
import pl.writeonly.son2.core.streamers.StreamerImplForeach

class StreamerXmlFeature extends FeatureSpec with GivenWhenThen {

  info("FileJson2XmlFeature with Json2Xml")

  val given = () => new StreamerImplForeach(FormatProvider(Formats.XML))

  val outName = (name: String) => Features.outputPathname(Types.STREAMER, name, Formats.XML)

  feature(classOf[StreamerXmlFeature].getSimpleName) {
    scenario("Apply with null pathname") {
      Given("converter FileJson2Xml")
      val streamer = given()
      val name: String = null

      When("should produce null when consume null")
      val caught = intercept[NullPointerException] {
        streamer.convertFile(name, name)
      }

      Then("null == messag")
      val message = caught.getMessage
      assert(null == message)
    }

    scenario("Apply with empty pathname") {
      Given("converter FileJson2Xml")
      val streamer = given()

      When("should produce empty when consume empty")
      assertThrows[FileNotFoundException] {
        streamer.convertFile("", "")
      }
    }

    scenario("Apply with pathname") {
      Given("converter FileJson2Xml")
      val streamer = given()
      val in = Features.inputPathname
      val out = outName("pathname")

      When("should produce null when consume null")
      streamer.convertFile(in, out)
    }

    scenario("Apply with uri") {
      Given("converter FileJson2Xml")
      val streamer = given()
      val in = Features.inputURI
      val out = Features.toURI(outName("uri"))

      When("should produce null when consume null")
      streamer.convertFile(in, out)
    }

    scenario("Apply with streamer") {
      Given("converter FileJson2Xml")
      val streamer = given()
      val in = Features.inputFile
      val out = Features.toFile(outName("streamer"))

      When("should produce out when consume in")
      streamer.convertFile(in, out)
    }
  }
}

