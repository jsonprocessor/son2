package pl.writeonly.son2.jack.converters

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import pl.writeonly.son2.apis.config.WStyle.WPretty
import pl.writeonly.son2.apis.converters.{Converter, Converter2}
import pl.writeonly.son2.funs.liners.{Liner, LinerOpt}
import pl.writeonly.son2.jack.core.{ConfigJack, FormatsJack}
import pl.writeonly.son2.jack.glue.CreatorConverterJack
import pl.writeonly.scalaops.specs.WhiteAssertSpec

class ObjectAssertSpec extends WhiteAssertSpec {

  val converter: Converter = CreatorConverterJack(FormatsJack.OBJECT).get
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

  val converterRaw: Converter = CreatorConverterJack(
    ConfigJack(FormatsJack.OBJECT)
  ).get
  "A ProviderRaw" should {
    "have pretty == true" in {
      assertResult(WPretty)(converterRaw.config.write.style)
    }
    "be  Provider2" in {
      assertResult(true)(converterRaw.isInstanceOf[Converter2])
    }
  }
  val provider2Raw = converterRaw.asInstanceOf[Converter2]
  "A Provider2Raw" should {
    //    "have pretty == false" in {
    //      assertResult(false)(provider2Raw.out.config.style)
    //    }
    //    "be not pretty" in {
    //      assertResult(false)(provider2Raw.out.pretty)
    //    }
  }
}
