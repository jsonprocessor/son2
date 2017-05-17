package pl.writeonly.son2.main


import pl.writeonly.son2.spec.WhiteSpec

class ResourcerWhite extends WhiteSpec {
  val resourcer: Resourcer = new Resourcer(null)

  "A Resourcer" when {
    "valid empty string" should {
      "return README" in {
        assert(resourcer.valid("") ==  Resources.README)
      }
    }
    "validOpt empty string" should {
      "return README" in {
        assert(resourcer.validOpt(Option("")) ==  Resources.README)
      }
    }
    "validOpt empty option" should {
      "return README" in {
        assert(resourcer.validOpt(Option.empty[String]) ==  Resources.README)
      }
    }
  }

}
