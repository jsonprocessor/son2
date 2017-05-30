package pl.writeonly.son2.jack.providers

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.formats.MatcherFormatProvider
import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.spec.WhiteResultSpec

class ObjectWordSpec extends WhiteResultSpec {

  val provider: ProviderJack = MatcherFormatProvider(Formats.OBJECT)
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
      assertResult(provider.comment("") + "\n")(liner.apply(""))
    }
  }
}
