package pl.writeonly.son2.jack.liners

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.providers.Provider
import pl.writeonly.son2.spec.WordFactory

class LinerEitherWord extends WordFactory {

  "A LinerEither" when {
    "apply empty string" should {
      "return ?" in {
        class ProviderStup extends Provider(Config(), null)
        val provider: Provider = stub[ProviderStup]
        val liner = new LinerEither(provider)
        liner.apply("")
      }
    }
  }

}
