package pl.writeonly.son2.funs.liners

import pl.writeonly.son2.apis.converters.ConverterFake
import pl.writeonly.sons.specs.WhiteAssertSpec

class LinerWithTryAssertSpec extends WhiteAssertSpec {

  "A LinerEither" when {
    "apply empty string" should {
      "return ?" in {
        new LinerWithTry(new ConverterFake).apply("")
      }
    }
  }

}
