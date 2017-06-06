package pl.writeonly.son2.jack.providers

import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.glue.MatcherFormatProviderJack
import pl.writeonly.son2.spec.WhiteResultSpec

class ProviderObjectResultSpec extends WhiteResultSpec {
  val provider: ProviderJack = MatcherFormatProviderJack(Formats.OBJECT)

  "A ProviderObject" when {
    "equals other ProviderObject" should {
      "return true" in {
        //        assertResult(MatcherFormatProvider(Formats.OBJECT))(provider)
      }
    }
  }
}
