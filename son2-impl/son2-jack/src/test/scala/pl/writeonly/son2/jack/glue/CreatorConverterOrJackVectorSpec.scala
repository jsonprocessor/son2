package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.spec.GrayVectorSpec

class CreatorConverterOrJackVectorSpec  extends GrayVectorSpec {
  val formats = Table("format", FormatsJack.ALL: _*)

  val creator = new CreatorConverterOrJack
  property("Apply CreatorConverterOrJack with format") {
    forAll(formats) { (format) =>
      val converter = creator.converterOr(format.name)
      converter.isGood should be (true)
    }
  }
}
