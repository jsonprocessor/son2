package pl.writeonly.son2.jack.providers

import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.jack.glue.CreatorProviderJack
import pl.writeonly.son2.spec.WhiteResultSpec

class ProviderObjectResultSpec extends WhiteResultSpec {
  val provider: Provider = CreatorProviderJack(FormatsJack.OBJECT)

  "A ProviderObject" when {
    "equals other ProviderObject" should {
      "return true" in {
        //        assertResult(MatcherFormatProvider(Formats.OBJECT))(provider)
      }
    }
  }
}
