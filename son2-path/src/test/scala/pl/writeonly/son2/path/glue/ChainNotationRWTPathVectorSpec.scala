package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.config.RConfig
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.spec.GrayVectorSpec

class ChainNotationRWTPathVectorSpec extends GrayVectorSpec {

  val providers = Table("format", ProvidersPath.ALL: _*)

  val chain = new ChainNotationRWTPath()

  property("ChainNotationRWTPath.r") {
    forAll(providers) { (provider) =>
      val config = RConfig(provider = provider)
      val creatorReader = chain.r
      creatorReader.isDefinedAt(config) should be(true)
      val reader = creatorReader.apply(config)
      reader.getClass
    }
  }
}
