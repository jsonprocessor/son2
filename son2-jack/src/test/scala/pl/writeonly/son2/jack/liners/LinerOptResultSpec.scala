package pl.writeonly.son2.jack.liners

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.providers.Provider
import pl.writeonly.son2.spec.WhiteResultSpec

class LinerOptResultSpec extends WhiteResultSpec {

  "A LinerOpt" when {
    "apply empty string" should {
      "return ?" in {
        class ProviderStub extends Provider(Config(), null)
        val provider: Provider = new ProviderStub()
        val liner = new LinerOpt(provider)
        assertResult("\n")(liner.apply(""))
      }
    }
  }

}
