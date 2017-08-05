package pl.writeonly.son2.text.glue

import pl.writeonly.son2.spec.GrayScalarSpec

class CreatorProviderOrTextScalarSpec extends GrayScalarSpec {
  describe("A Creator") {
    val creator = new CreatorProviderOrText
    it("when create provider with empty format") {
      creator provider "" should be an 'isBad
    }
  }
}
