package pl.writeonly.son2.json.glue

import pl.writeonly.son2.json.core.ProvidersJson
import pl.writeonly.sons.specs.GrayVectorSpec

class CreatorConverterOrJsonVectorSpec extends GrayVectorSpec {
  val providers = Table("format", ProvidersJson.ALL: _*)

  val creator = new CreatorConverterOrJson
  property("Apply CreatorConverterOrJson with provider") {
    forAll(providers) { (provider) =>
      val converter = creator.converterOr(provider.name)
      converter.isGood should be(true)
    }
  }
}
