package pl.writeonly.son2.main


import pl.writeonly.son2.spec.WhiteSpec

class ResourcerWhite extends WhiteSpec {
  val resourcer: Resourcer = new Resourcer(null)

  "A Resourcer" when {
    "valid empty " should {
      "return README" in {
        assert(resourcer.valid("") ==  Resources.README)
      }
    }
  }

}
