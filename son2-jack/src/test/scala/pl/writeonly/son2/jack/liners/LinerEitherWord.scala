package pl.writeonly.son2.jack.liners

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.providers.Provider
import pl.writeonly.son2.spec.WhiteSpec

class LinerEitherWord extends WhiteSpec {

  "A LinerEither" when {
    "apply empty string" should {
      "return ?" in {
        class ProviderStub extends Provider(Config(), null)
        val provider :Provider = new ProviderStub()
        val liner = new LinerEither(provider)
        liner.apply("")
      }
    }
  }

}
