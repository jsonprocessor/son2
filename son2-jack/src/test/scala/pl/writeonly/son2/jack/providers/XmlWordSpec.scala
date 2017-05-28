package pl.writeonly.son2.jack.providers

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.formats.MatcherFormatProvider
import pl.writeonly.son2.jack.liners.{Liner, LinerOpt}
import pl.writeonly.son2.spec.WhiteResultSpec

class XmlWordSpec extends WhiteResultSpec {

  val provider: Provider = MatcherFormatProvider(Formats.XML)
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
    "produce JsonMappingException when convert []" in {
      assertThrows[JsonMappingException] {
        provider.convert("[]")
      }
    }
    "produce JsonMappingException when convert [0,1]" in {
      assertThrows[JsonMappingException] {
        provider.convert("[0,1]")
      }
    }
  }

  val liner: Liner = new LinerOpt(provider)
  "A Liner" should {
    "return empty comment" in {
      assertResult(provider.comment("") + "\n")(liner.apply(""))
    }
  }
}
