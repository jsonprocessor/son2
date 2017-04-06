package pl.writeonly.son2.test.impl

import org.scalatest.{FeatureSpec, GivenWhenThen}
import pl.writeonly.son2.core.core.Formats

import scala.sys.process._

class CliSon2XmlFeature extends FeatureSpec with GivenWhenThen {

  val SON2ML = Features.SON2 + " x"

  val outName = (name: String) => Features.outputPathname(Types.CLI, name, Formats.XML)

  feature(classOf[CliSon2XmlFeature].getSimpleName) {

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
      assert("" == result)
    }
  }
}
