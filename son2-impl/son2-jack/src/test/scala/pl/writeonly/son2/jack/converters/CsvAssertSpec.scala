package pl.writeonly.son2.jack.converters

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import pl.writeonly.son2.apis.converters.Converter
import pl.writeonly.son2.funs.liners.{Liner, LinerOpt}
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.jack.glue.CreatorConverterJack
import pl.writeonly.scalaops.specs.WhiteAssertSpec

class CsvAssertSpec extends WhiteAssertSpec {

  val converter: Converter = CreatorConverterJack(FormatsJack.CSV).get
  "A Provider" should {
    "produce JsonParseException when convert a" in {
      assertThrows[JsonParseException] {
        converter.convert("a")
      }
    }
    "produce JsonMappingException when convert empty string" in {
      assertThrows[JsonMappingException] {
        converter.convert("")
      }
    }
  }

  val liner: Liner = new LinerOpt(converter)
  "A Liner" should {
    "return empty comment" in {
      assertResult(converter.comment("") + "\n")(liner.apply(""))
    }
  }
}
