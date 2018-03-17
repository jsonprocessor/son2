package pl.writeonly.son2.jack.converters

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.jack.glue.CreatorConverterJack
import pl.writeonly.sons.specs.WhiteAssertSpec

class JavaPropsAssertSpec extends WhiteAssertSpec {

  val provider: Converter = CreatorConverterJack(FormatsJack.JAVA_PROPS)
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
