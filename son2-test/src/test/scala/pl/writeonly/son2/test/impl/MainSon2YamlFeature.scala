package pl.writeonly.son2.test.impl

import java.io.FileNotFoundException

import org.scalatest.{FeatureSpec, GivenWhenThen}
import pl.writeonly.son2.impl.main.Main

class MainSon2YamlFeature extends FeatureSpec with GivenWhenThen {

  info(classOf[MainSon2YamlFeature].getSimpleName)
  
  val FORMAT = "yaml"

  val outName = (name: String) =>  Features.outputPathname("main", name, FORMAT)

  feature("MainJson2Yaml with two pathname") {
    scenario("Apply with null pathname") {
      Given("converter FileJson2Yaml")
      
      When("should produce null when consume null")
      val name: String = null
      val caught = intercept[NullPointerException] {
        Main.main(Array(FORMAT, name, name))
      }

      Then("null == messag")
      val message = caught.getMessage
      assert(null == message)
    }

    scenario("Apply with empty pathname") {
      Given("converter FileJson2Yaml")

      When("should produce empty when consume empty")
      assertThrows[FileNotFoundException] {
        Main.main(Array(FORMAT, "", ""))
      }
    }

    scenario("Apply with pathname") {
      Given("converter FileJson2Yaml")
      val in = Features.inputPathname
      val out = outName("pathname")

      When("should produce null when consume null")
      Main.main(Array(FORMAT, in, out))
    }
  }

  feature("MainJson2Yaml with one pathname") {
    scenario("Apply with null pathname") {
      Given("converter FileJson2Yaml")
      val name: String = null

      When("should produce null when consume null")
      val caught = intercept[NullPointerException] {
        Main.main(Array(FORMAT, name))
      }

      Then("null == messag")
      val message = caught.getMessage
      assert(null == message)
    }

    scenario("Apply with empty pathname") {
      Given("converter FileJson2Yaml")

      When("should produce null empty consume empty")
      assertThrows[FileNotFoundException] {
        Main.main(Array(FORMAT, ""))
      }
    }

    scenario("Apply with pathname") {
      Given("converter FileJson2Yaml")
      val in = Features.inputPathname

      When("should produce null when consume null")
      Main.main(Array(FORMAT, in))
    }
  }
}

