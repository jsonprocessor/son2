package pl.writeonly.son2.core

import pl.writeonly.son2.core.util.Control.toConsumerAny
import pl.writeonly.son2.spec.WhiteResultSpec

class ControlResultSpec extends WhiteResultSpec {

  "A Control" when {
    "s is true" should {
      val s = true
      "pipe return stream.isInstanceOf[StreamerPipeForeach]" in {
        val f = (x:String) => {}
        toConsumerAny(f).accept("param")
      }
    }
  }

}
