package pl.writeonly.scallions.jack.converters

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import pl.writeonly.scalaops.specs.WhiteAssertSpec
import pl.writeonly.scallions.apis.converters.Converter
import pl.writeonly.scallions.funs.liners.{Liner, LinerOpt}
import pl.writeonly.scallions.jack.core.FormatsJack
import pl.writeonly.scallions.jack.glue.CreatorConverterJack

class YamlAssertSpec extends WhiteAssertSpec {

  val converter: Converter = CreatorConverterJack(FormatsJack.YAML).get
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
