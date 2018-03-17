package pl.writeonly.son2.json.glue

import pl.writeonly.son2.json.core.ProvidersJson
import pl.writeonly.sons.specs.GrayVectorSpec

class CreatorConverterJsonVectorSpec extends GrayVectorSpec {

  val formats = Table("format", ProvidersJson.ALL: _*)

  val pf = new ChainNotationConfigJson().get
  val chain = new ChainNotationRWTJson
  val reader = chain.r
  val writer = chain.w
  property("PF should isDefinedAt for format") {
    forAll(formats) { (format) =>
      pf.isDefinedAt(format.name) should be(true)
      val config = pf.apply(format.name)
      reader.isDefinedAt(config.read) should be(true)
      writer.isDefinedAt(config.write) should be(true)

      reader.apply(config.read)
      writer.apply(config.write)
    }
  }
  property("Apply creatorConverterPath with format") {
    forAll(formats) { (format) =>
      CreatorConverterJson.apply(format)
    }
  }

}
