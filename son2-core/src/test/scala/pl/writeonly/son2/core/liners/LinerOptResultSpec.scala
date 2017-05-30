package pl.writeonly.son2.core.liners

import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.core.liners.LinerOpt
import pl.writeonly.son2.spec.WhiteResultSpec

class LinerOptResultSpec extends WhiteResultSpec {

  "A LinerOpt" when {
    "apply empty string" should {
      "return ?" in {
        class ConverterStub extends Converter {
          override def apply(content: String): String = content
        }
        class ProviderStub extends Provider(new ConverterStub)
        val provider: Provider = new ProviderStub
        val liner = new LinerOpt(provider)
        assertResult("\n")(liner.apply(""))
      }
    }
  }

}
