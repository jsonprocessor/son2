package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.spec.GrayVectorSpec

class CreatorConverterJackVectorSpec extends GrayVectorSpec {

  val formats = Table("format", FormatsJack.ALL: _*)

  val configer = new ChainNotationConfigJack().get
  val chain = new ChainNotationRWTJack
  val reader = chain.r
  val writer = chain.w
  property("PF should isDefinedAt for format") {
    forAll(formats) { (format) =>
      configer.isDefinedAt(format.name) should be(true)
      val config = configer.apply(format.name)
      reader.isDefinedAt(config.read) should be(true)
      writer.isDefinedAt(config.write) should be(true)

      val r = reader.apply(config.read)
      val w = writer.apply(config.write)
    }
  }
  property("Apply creatorConverterJack with format") {
    forAll(formats) { (format) =>
      CreatorConverterJack.apply(format)
    }
  }

}
