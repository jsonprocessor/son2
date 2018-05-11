package pl.writeonly.scallions.main

import java.io.FileNotFoundException

import pl.writeonly.scallions.funs.glue.{Params, Piper}
import pl.writeonly.scallions.impl.{Features, Types}
import pl.writeonly.scallions.jack.core.FormatsJack
import pl.writeonly.scalaops.specs.BlackSpec
import pl.writeonly.scallions.jack.core.FormatsJack
import pl.writeonly.scallions.jack.glue.CreatorConverterJack

class PiperSon2ObjectFeatureSpec extends BlackSpec {

  val given = () =>
    new Piper(
      Params(System.in, System.out),
      CreatorConverterJack(FormatsJack.OBJECT).get
  )

  val outName = (name: String) =>
    Features.outputPathname(Types.PIPER, name, FormatsJack.OBJECT)

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
