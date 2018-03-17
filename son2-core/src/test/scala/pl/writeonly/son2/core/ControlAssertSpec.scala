package pl.writeonly.son2.core

import pl.writeonly.sons.specs.WhiteAssertSpec
import pl.writeonly.sons.utils.ops.Control.{FAAny, toConsumerAny}

class ControlAssertSpec extends WhiteAssertSpec {

  "A Control" when {
    "s is true" should {
      val s = true
      "pipe return stream.isInstanceOf[StreamerPipeForeach]" in {
        val f: FAAny[String] = (_: String) => {}
        toConsumerAny(f).accept("param")
      }
    }
  }

}
