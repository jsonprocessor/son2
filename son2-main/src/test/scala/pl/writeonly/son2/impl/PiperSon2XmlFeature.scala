package pl.writeonly.son2.impl

import java.io.FileNotFoundException

import org.scalatest.{FeatureSpec, GivenWhenThen}
import pl.writeonly.son2.core.core.Formats
import pl.writeonly.son2.core.formats.MatcherFormatProvider
import pl.writeonly.son2.impl.main.Piper

class PiperSon2XmlFeature extends FeatureSpec with GivenWhenThen {

  val given = () => new Piper(MatcherFormatProvider(Formats.XML))

  val outName = (name: String) => Features.outputPathname(Types.PIPER, name, Formats.XML)

  feature(classOf[PiperSon2XmlFeature].getSimpleName) {
    scenario("Apply with null pathname") {
      Given("converter FileJson2Xml")
      val piper = given()

      When("should produce null when consume null")
      val name: String = null
      val caught = intercept[NullPointerException] {
        piper.convertFile(name, name)
      }

      Then("null == messag")
      val message = caught.getMessage
      assert(null == message)
    }

    scenario("Apply with empty pathname") {
      Given("converter FileJson2Xml")
      val piper = given()

      When("should produce empty when consume empty")
      assertThrows[FileNotFoundException] {
        piper.convertFile("", "")
      }
    }

    scenario("Apply with pathname") {
      Given("converter FileJson2Xml")
      val piper = given()
      val in = Features.inputPathname
      val out = outName("pathname")

      When("should produce null when consume null")
      piper.convertFile(in, out)
    }
  }
}

