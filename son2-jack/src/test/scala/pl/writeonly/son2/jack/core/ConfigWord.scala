package pl.writeonly.son2.jack.core

import pl.writeonly.son2.spec.WhiteResultSpec

class ConfigWord extends WhiteResultSpec {
  val config = Config()
  val other = Config.apply()
  "A Config" when {
    "equals other config" should {
      "return true" in {
        assert (config == other)
      }
    }
    "hashCode equals other config" should {
      "return true" in {
        assert (config.hashCode() == other.hashCode())
      }
    }
  }
}
