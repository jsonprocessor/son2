package pl.writeonly.son2.test.impl

import java.io.FileNotFoundException

import org.scalatest.{FeatureSpec, GivenWhenThen}
import pl.writeonly.son2.impl.core.providers.ProviderObject
import pl.writeonly.son2.impl.main.Piper

class PiperSon2ObjectFeature extends FeatureSpec with GivenWhenThen {

  info("MainJson2YamlImpl with Json2YamlJackson")

  val given = () => new Piper(new ProviderObject)

  val outName = (name: String) =>  Features.outputPathname("piper", name, "object")

  feature("MainSon2Objec with two pathname") {
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

