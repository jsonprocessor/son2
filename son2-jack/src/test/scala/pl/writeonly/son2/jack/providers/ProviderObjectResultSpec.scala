package pl.writeonly.son2.jack.providers

import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.chain.ChainNotationPairJack
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.glue.ProviderCreatorJack
import pl.writeonly.son2.spec.WhiteResultSpec

class ProviderObjectResultSpec extends WhiteResultSpec {
  val provider: Provider = ChainNotationPairJack(Formats.OBJECT)

  "A ProviderObject" when {
    "equals other ProviderObject" should {
      "return true" in {
        //        assertResult(MatcherFormatProvider(Formats.OBJECT))(provider)
      }
    }
  }
}
