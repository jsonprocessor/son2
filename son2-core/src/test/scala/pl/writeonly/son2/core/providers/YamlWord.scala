package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import org.scalatest.{Matchers, WordSpec}
import pl.writeonly.son2.core.formats.FormatProvider
import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.core.core.Formats
import pl.writeonly.son2.core.providers.Provider

class YamlWord extends WordSpec with Matchers {

  val provider: Provider = FormatProvider(Formats.YAML)
  "A Provider" should {
    "produce JsonParseException when convert a" in {
      assertThrows[JsonParseException] {
        provider.convert("a")
      }
    }
    "produce JsonMappingException when convert empty string" in {
      assertThrows[JsonMappingException] {
        provider.convert("")
      }
    }
  }

  val liner: Liner = new LinerOpt(provider)
  "A Liner" should {
    "return empty comment" in {
      liner.apply("") should be(provider.comment("") + "\n")
    }
  }
}
