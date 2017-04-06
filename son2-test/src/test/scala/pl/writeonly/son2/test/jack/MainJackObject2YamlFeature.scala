package pl.writeonly.son2.test.jack

import org.scalatest.{FeatureSpec, GivenWhenThen}
import pl.writeonly.son2.core.core.Formats._
import pl.writeonly.son2.jack.main.Main
import pl.writeonly.son2.test.impl.{Features, Types}

class MainJackObject2YamlFeature extends FeatureSpec with GivenWhenThen {
  info(classOf[MainJackObject2YamlFeature].getSimpleName)


  val outName = (name: String) => Features.outputPathname(Types.JACK, OBJECT, name, YAML)

  feature("Convert object to yaml") {
    scenario("Apply with null pathname") {
      //      Given("converter FileJson2Yaml")
      //      val main = given()
      val in = Features.inputPathname
      val out = outName("two")
      //
      //      When("should produce null when consume null")
      //      val name: String = null
      //
      Main.main(Array(OBJECT, YAML, in, out))
      //
      //
      //      Then("null == messag")
      //      val message = caught.getMessage
      //      assert(null == message)
    }


  }

}
