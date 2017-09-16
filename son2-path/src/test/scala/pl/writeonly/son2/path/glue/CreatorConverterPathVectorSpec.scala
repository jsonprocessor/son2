package pl.writeonly.son2.path.glue

import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.spec.GrayVectorSpec

class CreatorConverterPathVectorSpec extends GrayVectorSpec {

  val formats = Table("format", ProvidersPath.ALL: _*)


  val pf = new ChainNotationConfigPath().get
  val chain = new ChainNotationRWTPath
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
      CreatorConverterPath.apply(format)
    }
  }

}
