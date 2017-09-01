package pl.writeonly.son2.core.liners

import pl.writeonly.son2.core.converters.ConverterFake
import pl.writeonly.son2.spec.WhiteResultSpec

class LinerEitherResultSpec extends WhiteResultSpec {

  "A LinerEither" when {
    "apply empty string" should {
      "return ?" in {
        new LinerEither(new ConverterFake).apply("")
      }
    }
  }

}
