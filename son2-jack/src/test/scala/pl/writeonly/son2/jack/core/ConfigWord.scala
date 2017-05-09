package pl.writeonly.son2.jack.core

import org.scalatest.WordSpec

class ConfigWord extends WordSpec {
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
