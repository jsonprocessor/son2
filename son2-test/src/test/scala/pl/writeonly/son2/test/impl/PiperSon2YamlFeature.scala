package pl.writeonly.son2.test.impl

import java.io.FileNotFoundException

import org.scalatest.{FeatureSpec, GivenWhenThen}
import pl.writeonly.son2.impl.core.providers.ProviderYaml
import pl.writeonly.son2.impl.main.Piper

class PiperSon2YamlFeature extends FeatureSpec with GivenWhenThen {

  info("MainJson2YamlImpl with Json2YamlJackson")

  val given = () => new Piper(new ProviderYaml)

  val outName = (name: String) =>  Features.outputPathname("piper", name, "yaml")

  feature("MainJson2Yaml with two pathname") {
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

  feature("MainJson2Yaml with one pathname") {
    scenario("Apply with null pathname") {
      Given("converter FileJson2Yaml")
      val piper = given()
      val name: String = null

      When("should produce null when consume null")
      val caught = intercept[NullPointerException] {
        piper.convertFile(name)
      }

      Then("null == messag")
      val message = caught.getMessage
      assert(null == message)
    }

    scenario("Apply with empty pathname") {
      Given("converter FileJson2Yaml")
      val piper = given()

      When("should produce null empty consume empty")
      assertThrows[FileNotFoundException] {
        piper.convertFile("")
      }
    }

    scenario("Apply with pathname") {
      Given("converter FileJson2Yaml")
      val piper = given()
      val in = Features.inputPathname

      When("should produce null when consume null")
      piper.convertFile(in)
    }
  }
}

