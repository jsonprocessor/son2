package pl.writeonly.son2.json.providers

import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.jack.glue.CreatorConverterJack
import pl.writeonly.son2.spec.WhiteResultSpec

class ConverterObjectResultSpec extends WhiteResultSpec {
  val provider: Converter = CreatorConverterJack(FormatsJack.OBJECT)

  "A ConverterObject" when {
    "equals other ConverterObject" should {
      "return true" in {
        //        assertResult(MatcherFormatProvider(Formats.OBJECT))(provider)
      }
    }
  }
}
