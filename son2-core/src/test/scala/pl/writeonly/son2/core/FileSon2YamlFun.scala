package pl.writeonly.son2.core

import org.scalatest.FunSpec

class FileSon2YamlFun extends FunSpec {
  describe("A FileJson2YamlSpec") {
    var onml:FileSon2 = new FileSon2Impl(new Son2Yaml())

    describe("when left") {
      it("should produce null when consume null") {
        val yaml = onml.convertString(null)
        assert(null == yaml)
      }
//      it("should produce empty comment when consume empty string") {
//        val yaml = onml.applyTry("")
//        assert("#" == yaml)
//      }
//      it("should produce a when consume a") {
//        val yaml = onml.applyTry("a")
//        assert("#a" == yaml)
//      }
    }
  }
}
