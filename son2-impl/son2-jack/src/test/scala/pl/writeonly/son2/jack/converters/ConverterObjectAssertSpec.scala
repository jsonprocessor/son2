package pl.writeonly.son2.jack.converters

import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.jack.glue.CreatorConverterJack
import pl.writeonly.son2.spec.WhiteAssertSpec

class ConverterObjectAssertSpec extends WhiteAssertSpec {
  val provider: Converter = CreatorConverterJack(FormatsJack.OBJECT)

  "A ConverterObject" when {
    "equals other ConverterObject" should {
      "return true" in {
        //        assertResult(MatcherFormatProvider(Formats.OBJECT))(provider)
      }
    }
  }
}
