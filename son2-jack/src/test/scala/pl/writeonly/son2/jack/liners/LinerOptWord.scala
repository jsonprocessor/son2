package pl.writeonly.son2.jack.liners

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.providers.Provider
import pl.writeonly.son2.spec.WhiteSpec

class LinerOptWord extends WhiteSpec {

  "A LinerOpt" when {
    "apply empty string" should {
      "return ?" in {
        class ProviderStub extends Provider(Config(), null)
//        val provider: Provider = stub[ProviderStub]
        val provider :Provider = new ProviderStub();
        val liner = new LinerOpt(provider)
        liner.apply("")
      }
    }
  }

}
