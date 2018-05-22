package pl.writeonly.scallions.main

import java.io.FileNotFoundException

import pl.writeonly.scalaops.specs.BlackSpec
import pl.writeonly.scallions.impl.{Features, Types}
import pl.writeonly.scallions.jack.core.FormatsJack

class MainSon2YamlFeatureSpec extends BlackSpec {

  info(classOf[MainSon2YamlFeatureSpec].getSimpleName)

  val outName = (name: String) =>
    Features.outputPathname(Types.MAIN, name, FormatsJack.YAML)

  feature(classOf[MainSon2YamlFeatureSpec].getSimpleName) {
    scenario("Apply with null pathname") {
      Given("converter FileJson2Yaml")

      When("should produce null when consume null")
      val name: String = null
      val caught = intercept[NullPointerException] {
        Main.main(Array(FormatsJack.YAML.name, name, name))
      }

      Then("null == messag")
      val message = caught.getMessage
      assert(null == message)
    }

    scenario("Apply with empty pathname") {
      Given("converter FileJson2Yaml")

      When("should produce empty when consume empty")
      assertThrows[FileNotFoundException] {
        Main.main(Array(FormatsJack.YAML.name, "", ""))
      }
    }

    scenario("Apply with pathname") {
      Given("converter FileJson2Yaml")
      val in = Features.inputPathname
      val out = outName("pathname")

      When("should produce null when consume null")
      Main.main(Array(FormatsJack.YAML.name, in, out))
    }
  }
}
