package pl.writeonly.son2.text.glue

import pl.writeonly.son2.spec.GrayScalarSpec

class CreatorConverterOrTextScalarSpec extends GrayScalarSpec {
  describe("A Creator") {
    val creator = new CreatorConverterOrText
    it("when create provider with empty format") {
      creator converterOr "" should be an 'isBad
    }
  }
}
