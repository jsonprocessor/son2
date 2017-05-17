package pl.writeonly.son2.jack.providers

import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.formats.MatcherFormatProvider
import pl.writeonly.son2.spec.WhiteSpec

class ProviderObjectWhite extends WhiteSpec {
  val provider: Provider = MatcherFormatProvider(Formats.OBJECT)

  "A ProviderObject" when {
    "equals other ProviderObject" should {
      "return true" in {
        assert (provider == MatcherFormatProvider(Formats.OBJECT))
      }
    }
  }
}
