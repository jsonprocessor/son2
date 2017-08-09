package pl.writeonly.son2.jack.providers

import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.chain.ChainNotationPairJack
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.spec.WhiteResultSpec

class ProviderObjectResultSpec extends WhiteResultSpec {
  val provider: Provider = ChainNotationPairJack(FormatsJack.OBJECT)

  "A ProviderObject" when {
    "equals other ProviderObject" should {
      "return true" in {
        //        assertResult(MatcherFormatProvider(Formats.OBJECT))(provider)
      }
    }
  }
}
