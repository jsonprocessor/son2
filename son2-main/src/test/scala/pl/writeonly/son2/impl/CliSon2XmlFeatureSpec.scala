package pl.writeonly.son2.impl

import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.spec.BlackSpec

import scala.sys.process._

class CliSon2XmlFeatureSpec extends BlackSpec {

  val SON2ML = Features.SON2 + " x"

  val outName = (name: String) => Features.outputPathname(Types.CLI, name, Formats.XML)

  feature(classOf[CliSon2XmlFeatureSpec].getSimpleName) {

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
      Then("'' == result")
      assert("" == result)
    }
  }
}
