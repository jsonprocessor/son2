package pl.writeonly.son2.jack.glue

import org.skyscreamer.jsonassert.JSONAssert
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.spec.GrayVectorSpec

class CreatorConverterJackVectorSpec extends GrayVectorSpec {

  val providers = Table("format", FormatsJack.ALL: _*)


  val configer = new ChainNotationConfigJack().get
  val chain = new ChainNotationRWTJack
  val reader = chain.r
  val writer = chain.w
  property("PF should isDefinedAt for format") {
    forAll(providers) { (provider) =>
      configer.isDefinedAt(provider.name) should be(true)
      val config = configer.apply(provider.name)
      reader.isDefinedAt(config.read) should be(true)
      writer.isDefinedAt(config.write) should be(true)

      val r = reader.apply(config.read)
      val w = writer.apply(config.write)
    }
  }
  property("Apply creatorConverterJack with format") {
    forAll(providers) { (provider) =>
      CreatorConverterJack.apply(provider)
    }
  }

}
