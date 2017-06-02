package pl.writeonly.son2.core.liners

import pl.writeonly.son2.core.converters.ConverterImpl
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.spec.WhiteResultSpec

class LinerEitherResultSpec extends WhiteResultSpec {

  "A LinerEither" when {
    "apply empty string" should {
      "return ?" in {
        class ConverterStub extends ConverterImpl(null, null) {
          override def apply(content: String): String = content
        }
        class ProviderStub extends Provider(new ConverterStub)
        val provider: Provider = new ProviderStub
        val liner = new LinerEither(provider)
        liner.apply("")
      }
    }
  }

}
