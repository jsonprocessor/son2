package pl.writeonly.son2.test.jack

import java.io.FileNotFoundException

import org.scalatest.{FeatureSpec, GivenWhenThen}
import pl.writeonly.son2.test.impl.Features

import pl.writeonly.son2.jack.main.Main

class MainJackJson2YamlFeature extends FeatureSpec with GivenWhenThen{
  info("MainJson2YamlImpl with Json2YamlJackson")

  val given = () => Main.self

  val outName = (name: String) =>  Features.outputPathname("main", name, "object")

  feature("MainSon2Objec with two pathname") {
    scenario("Apply with null pathname") {
//      Given("converter FileJson2Yaml")
//      val main = given()
//
//      When("should produce null when consume null")
//      val name: String = null
//
//      main.main("object", "yaml", )
//
//
//      Then("null == messag")
//      val message = caught.getMessage
//      assert(null == message)
    }


  }

}
