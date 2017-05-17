package pl.writeonly.son2.main

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.providers.ProviderObject
import pl.writeonly.son2.spec.WhiteSpec

class MainWhite extends WhiteSpec {

  "A Main with empty array" when {
    "invoke option" should {
      "return Left(None)" in {
        assert(new Main(null, Array()).option == Left(None))
      }
    }
  }

  "A Main with README in array" when {
    "invoke option" should {
      "return Left(Option(readme)" in {
        assert(new Main(null, Array("README")).option == Left(Some("readme")))
      }
    }
  }

  "A Main with empty string in array" when {
    "invoke option" should {
      "return ProviderObject(Config())" in {
        assert(new Main(null, Array("")).option == Right(new ProviderObject(Config(o=""))))
      }
    }
  }

}
