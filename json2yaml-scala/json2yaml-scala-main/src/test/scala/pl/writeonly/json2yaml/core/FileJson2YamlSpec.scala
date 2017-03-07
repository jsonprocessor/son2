package pl.scalare.util.asap

import org.scalatest.{FunSpec, GivenWhenThen}

class FileJson2YamlSpec extends FunSpec with GivenWhenThen {
  describe("A FileJson2YamlSpec") {
    var io = new FileJson2YamlIO(new Json2YamlJackson())

    describe("when left") {
      it("should produce null when consume null") {
        val yaml = io.convert(null)
        assert(null == yaml)
      }
      it("should produce empty comment when consume empty string") {
        val yaml = onml.applyTry("")
        assert("#" == yaml)
      }
      it("should produce a when consume a") {
        val yaml = onml.applyTry("a")
        assert("#a" == yaml)
      }
    }
  }
}
