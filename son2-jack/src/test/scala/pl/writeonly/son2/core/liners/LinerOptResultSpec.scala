package pl.writeonly.son2.core.liners

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.providers.ProviderJack
import pl.writeonly.son2.spec.WhiteResultSpec

class LinerOptResultSpec extends WhiteResultSpec {

  "A LinerOpt" when {
    "apply empty string" should {
      "return ?" in {
        class ProviderStub extends ProviderJack(Config(), null)
        val provider: ProviderJack = new ProviderStub()
        val liner = new LinerOpt(provider)
        assertResult("\n")(liner.apply(""))
      }
    }
  }

}
