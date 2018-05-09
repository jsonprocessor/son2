package pl.writeonly.son2.main

import pl.writeonly.son2.funs.glue.Params
import pl.writeonly.scalaops.specs.WhiteAssertSpec

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
