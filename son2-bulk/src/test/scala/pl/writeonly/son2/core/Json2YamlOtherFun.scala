package pl.writeonly.son2.core

import org.scalatest.{FunSpec, Ignore}

@Ignore
class Json2YamlOtherFun extends FunSpec {

  describe("A Json2Yaml") {
    val onml: Liner = new Son2Other()

    describe("when left") {
      it("should produce null when consume null") {
        val yaml = onml.applyTry(null)
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

    describe("when right") {
      it("should produce empty when consume empty array") {
        val yaml = onml.applyTry("[]")
        assert("--- []\n" == yaml)
      }
      it("should produce array when consume array") {
        val yaml = onml.applyTry("[0]")
        assert("---\n- 0\n" == yaml)
      }
      it("should produce array 2 when consume array 2") {
        val yaml = onml.applyTry("[0,1]")
        assert("---\n- 0\n- 1\n" == yaml)
      }
      it("should produce object when consume empty object") {
        val yaml = onml.applyTry("{}")
        assert("--- {}\n" == yaml)
      }
      it("should produce object when consume object") {
        val yaml = onml.applyTry("{\"a\":0}")
        assert("---\na: 0\n" == yaml)
      }
      it("should produce object 2 when consume object 2") {
        val yaml = onml.applyTry("{\"a\":0, \"b\":1}")
        assert("---\na: 0\nb: 1\n" == yaml)
      }
      it("should produce object array when consume object array") {
        val yaml = onml.applyTry("[{}]")
        assert("---\n- {}\n" == yaml)
      }
      it("should produce array object when consume array object") {
        val yaml = onml.applyTry("{\"a\":[]}")
        assert("---\na: []\n" == yaml)
      }

      it("should produce a when consume 'a'") {
        val yaml = onml.applyTry("\"a\"")
        assert("--- \"a\"\n" == yaml)
      }


    }
  }

}
