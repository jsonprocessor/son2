package pl.writeonly.son2.jack.core

import pl.writeonly.son2.spec.WhiteAssertSpec

class RWTConfigAssertSpec extends WhiteAssertSpec {
  val config = ConfigJack(FormatsJack.YAML)
  val other = ConfigJack.apply(FormatsJack.YAML)
  "A Config" when {
    "equals other config" should {
      "return true" in {
        //        assertResult(other)(config)
      }
    }
    "hashCode equals other config" should {
      "return true" in {
        //        assertResult(other.hashCode())(config.hashCode())
      }
    }
  }
}
