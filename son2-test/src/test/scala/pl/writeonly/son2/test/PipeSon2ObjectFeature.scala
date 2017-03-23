package pl.writeonly.son2.test

import org.scalatest.{FeatureSpec, GivenWhenThen}

import scala.sys.process._

class PipeSon2ObjectFeature extends FeatureSpec with GivenWhenThen {

  val SON2 = "java -jar ../son2-main/target/son2-main-2.8.3-SNAPSHOT.jar"
  val SON2ML = SON2 + " o"
  val CAT = "cat"

  val outName = (name: String) =>  Features.outputPathname("pipe", name, "object")

  feature(classOf[PipeSon2ObjectFeature].getSimpleName) {

    scenario("Apply one exclamation") {
      Given("converter FileJson2Yaml")
      val in = Features.inputPathname
      val file = SON2ML + " " + in + " " + outName("one")
      When("should produce null when consume null")
      val result = file.!
      Then("0 == result")
      assert(0 == result)
    }

    scenario("Apply two exclamation") {
      Given("converter FileJson2Yaml")
      val in = Features.inputPathname
      val file = SON2ML + " " + in + " " + outName("two")
      When("should produce null when consume null")
        val result = file.!!
      Then("0 == result")
      assert("" == result)    }
  }
}
