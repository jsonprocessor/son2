package pl.writeonly.son2.jack.core

import pl.writeonly.son2.spec.WhiteResultSpec

class ConfigResultSpec extends WhiteResultSpec {
  val config = Config()
  val other = Config.apply()
  "A Config" when {
    "equals other config" should {
      "return true" in {
        assertResult (other) (config)
      }
    }
    "hashCode equals other config" should {
      "return true" in {
        assertResult (other.hashCode()) (config.hashCode())
      }
    }
  }
}
