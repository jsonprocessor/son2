package pl.writeonly.son2.text.glue

import pl.writeonly.son2.spec.GrayScalarSpec

class CreatorConverterOrTextScalarSpec extends GrayScalarSpec {
  val creator = new CreatorConverterOrText
  it should "when create provider with empty format" in {
    creator converterOr "" should be an 'isBad
  }

}
