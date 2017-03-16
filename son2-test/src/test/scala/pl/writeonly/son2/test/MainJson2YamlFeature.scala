package pl.writeonly.son2.test

import java.io.FileNotFoundException

import org.scalatest.{FeatureSpec, GivenWhenThen}

import pl.writeonly.son2.core._
import pl.writeonly.son2.main._

class MainJson2YamlFeature extends FeatureSpec with GivenWhenThen {

  info("MainJson2YamlImpl with Json2YamlJackson")

  val given = () => new MainJson2Yaml(new FileJson2YamlImpl(new Json2YamlJackson))

  val outName = (name: String) =>  Features.outputPathname("main", name)

  feature("MainJson2Yaml with two pathname") {
    scenario("Apply with null pathname") {
      Given("converter FileJson2Yaml")
      val main = given()

      When("should produce null when consume null")
      val name: String = null
      val caught = intercept[NullPointerException] {
        main.convertFile(name, name)
      }

      Then("null == messag")
      val message = caught.getMessage
      assert(null == message)
    }

    scenario("Apply with empty pathname") {
      Given("converter FileJson2Yaml")
      val main = given()

      When("should produce empty when consume empty")
      assertThrows[FileNotFoundException] {
        main.convertFile("", "")
      }
    }

    scenario("Apply with pathname") {
      Given("converter FileJson2Yaml")
      val main = given()
      val in = Features.inputPathname
      val out = outName("pathname")

      When("should produce null when consume null")
      main.convertFile(in, out)
    }
  }

  feature("MainJson2Yaml with one pathname") {
    scenario("Apply with null pathname") {
      Given("converter FileJson2Yaml")
      val main = given()
      val name: String = null

      When("should produce null when consume null")
      val caught = intercept[NullPointerException] {
        main.convertFile(name)
      }

      Then("null == messag")
      val message = caught.getMessage
      assert(null == message)
    }

    scenario("Apply with empty pathname") {
      Given("converter FileJson2Yaml")
      val main = given()

      When("should produce null empty consume empty")
      assertThrows[FileNotFoundException] {
        main.convertFile("")
      }
    }

    scenario("Apply with pathname") {
      Given("converter FileJson2Yaml")
      val main = given()
      val in = Features.inputPathname

      When("should produce null when consume null")
      main.convertFile(in)
    }
  }
}

