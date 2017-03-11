package pl.writeonly.json2yaml.core

import org.scalatest.{FeatureSpec, GivenWhenThen}

class FileJson2YamlFeature extends FeatureSpec with GivenWhenThen {

  info("As a TV set owner")
  info("I want to be able to turn the TV on and off")
  info("So I can watch TV when I want")
  info("And save energy when I'm not watching TV")

  feature("TV power button") {
    scenario("User presses power button when TV is off") {

      Given("a TV set that is switched off")
      var onml:FileJson2Yaml = new FileJson2YamlImpl(new Json2YamlJackson())

      When("should produce null when consume null")
//      onml.convert(null, null)
//
      Then("the TV should switch on")
//      assert(tv.isOn)
    }

    scenario("User presses power button when TV is on") {

//      Given("a TV set that is switched on")
//      val tv = new TVSet
//      tv.pressPowerButton()
//      assert(tv.isOn)
//
//      When("the power button is pressed")
//      tv.pressPowerButton()
//
//      Then("the TV should switch off")
//      assert(!tv.isOn)
    }
  }
}

