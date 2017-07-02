package pl.writeonly.son2.main

import java.io.FileNotFoundException

import pl.writeonly.son2.impl.{Features, Types}
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.glue.MatcherFormatProviderJack
import pl.writeonly.son2.spec.BlackSpec

class PiperSon2ObjectFeatureSpec extends BlackSpec {

  val given = () => new Piper(Params(System.in, System.out), MatcherFormatProviderJack(Formats.OBJECT))

  val outName = (name: String) => Features.outputPathname(Types.PIPER, name, Formats.OBJECT)

  feature(classOf[PiperSon2ObjectFeatureSpec].getSimpleName) {
    scenario("Apply with null pathname") {
      Given("converter FileJson2Yaml")
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
      Given("converter FileJson2Yaml")
      val piper = given()

      When("should produce empty when consume empty")
      assertThrows[FileNotFoundException] {
        piper.convertFile("", "")
      }
    }

    scenario("Apply with pathname") {
      Given("converter FileJson2Yaml")
      val piper = given()
      val in = Features.inputPathname
      val out = outName("pathname")

      When("should produce null when consume null")
      piper.convertFile(in, out)
    }
  }
}

