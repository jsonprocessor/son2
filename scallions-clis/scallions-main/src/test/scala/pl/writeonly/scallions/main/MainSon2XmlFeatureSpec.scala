package pl.writeonly.scallions.main

import java.io.FileNotFoundException

import pl.writeonly.scalaops.specs.BlackSpec
import pl.writeonly.scallions.impl.{Features, Types}
import pl.writeonly.scallions.jack.core.FormatsJack

class MainSon2XmlFeatureSpec extends BlackSpec {

  val outName = (name: String) =>
    Features.outputPathname(Types.MAIN, name, FormatsJack.XML)

  feature(classOf[MainSon2XmlFeatureSpec].getSimpleName) {
    scenario("Apply with null pathname") {
      Given("converter FileJson2Xml")
      val name: String = null

      When("should produce null when consume null")
      val caught = intercept[NullPointerException] {
        Main.main(Array(FormatsJack.XML.name, name, name))
      }

      Then("null == messag")
      val message = caught.getMessage
      assert(null == message)
    }

    scenario("Apply with empty pathname") {
      Given("converter FileJson2Xml")

      When("should produce empty when consume empty")
      assertThrows[FileNotFoundException] {
        Main.main(Array(FormatsJack.XML.name, "", ""))
      }
    }

    scenario("Apply with pathname") {
      Given("converter FileJson2Xml")
      val in = Features.inputPathname
      val out = outName("pathname")

      When("should produce null when consume null")
      Main.main(Array(FormatsJack.XML.name, in, out))
    }
  }
}
