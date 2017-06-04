package pl.writeonly.son2.jack.providers

import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.glue.MatcherFormatProvider
import pl.writeonly.son2.spec.WhiteResultSpec

class ProviderObjectResultSpec extends WhiteResultSpec {
  val provider: ProviderJack = MatcherFormatProvider(Formats.OBJECT)

  "A ProviderObject" when {
    "equals other ProviderObject" should {
      "return true" in {
//        assertResult(MatcherFormatProvider(Formats.OBJECT))(provider)
      }
    }
  }
}
