package pl.writeonly.son2.main

import java.io.FileNotFoundException

import pl.writeonly.son2.core.glue.{Params, Piper}
import pl.writeonly.son2.impl.{Features, Types}
import pl.writeonly.son2.jack.chain.ChainNotationPairJack
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.spec.BlackSpec

class PiperSon2XmlFeatureSpec extends BlackSpec {

  val given = () => new Piper(Params(System.in, System.out), ChainNotationPairJack(Formats.XML))

  val outName = (name: String) => Features.outputPathname(Types.PIPER, name, Formats.XML)

  feature(classOf[PiperSon2XmlFeatureSpec].getSimpleName) {
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

