package pl.writeonly.scallions.main

import pl.writeonly.scalaops.specs.WhiteAssertSpec
import pl.writeonly.scallions.funs.glue.Params

class ParamsAssertSpec extends WhiteAssertSpec {
  val params = Params(System.in, System.out)
  val other = Params.apply(System.in, System.out)
  "A Params" when {
    "equals other params" should {
      "return true" in {
        assertResult(params)(other)
      }
    }
    "hashCode equals other params" should {
      "return true" in {
        assertResult(params.hashCode())(other.hashCode())
      }
    }
  }
}
