package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.jack.core.{FormatsJack, Jack}
import pl.writeonly.sons.specs.GrayVectorSpec

class CreatorConverterJackVectorSpec extends GrayVectorSpec {

  val formats = Table("format", FormatsJack.ALL: _*)

  val configer = new ChainNotationConfigJack().get
  val chain = new ChainNotationRWTJack
  val reader = chain.r
  val writer = chain.w
  property("PF should isDefinedAt for format") {
    forAll(formats) { (format) =>
      configer.isDefinedAt(format.name) shouldBe true
      val config = configer.apply(format.name)
      reader.isDefinedAt(config.read) shouldBe true
      writer.isDefinedAt(config.write) shouldBe true

      val r = reader.apply(config.read)
      val w = writer.apply(config.write)
    }
  }
  property("Apply creatorConverterJack with format") {
    forAll(formats) { (format) =>
      val converter = CreatorConverterJack.apply(format)
      withClue(s"$format ${converter}") {
        converter.isGood shouldBe true
        converter.get.metas._1 shouldBe Jack.meta(FormatsJack.OBJECT)
        converter.get.metas._2 shouldBe Jack.meta(format)
      }
    }
  }
}
