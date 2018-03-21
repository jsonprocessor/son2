package pl.writeonly.son2.funs.liners

import pl.writeonly.son2.apis.converters.ConverterFake
import pl.writeonly.sons.specs.WhiteAssertSpec

class LinerOptAssertSpec extends WhiteAssertSpec {

  "A LinerOpt" when {
    "apply empty string" should {
      "return ?" in {
        assertResult("\n")(new LinerOpt(new ConverterFake).apply(""))
      }
    }
  }

}
