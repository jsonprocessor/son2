package pl.writeonly.son2.core.liners

import pl.writeonly.son2.core.converters.ConverterFake
import pl.writeonly.son2.spec.WhiteResultSpec

class LinerOptResultSpec extends WhiteResultSpec {

  "A LinerOpt" when {
    "apply empty string" should {
      "return ?" in {
        assertResult("\n")(new LinerOpt(new ConverterFake).apply(""))
      }
    }
  }

}
