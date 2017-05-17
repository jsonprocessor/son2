package pl.writeonly.son2.main

import java.io.ByteArrayOutputStream

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.providers.ProviderObject
import pl.writeonly.son2.jack.streamers.Streamer
import pl.writeonly.son2.spec.WhiteSpec

class MainerWhite extends WhiteSpec {

  "A Mainer with empty array" when {
    "invoke option" should {
      "return Left(None)" in {
        assert(new Mainer(null, Array()).option == Left(None))
      }
    }
  }

  "A Mainer with README in array" when {
    "invoke option" should {
      "return Left(Option(readme)" in {
        assert(new Mainer(null, Array("README")).option == Left(Some("readme")))
      }
    }
  }

  "A Mainer with empty string in array" when {
    "invoke option" should {
      "return ProviderObject(Config())" in {
        assert(new Mainer(null, Array("")).option == Right(new ProviderObject(Config(o=""))))
      }
    }
    "invoke either" should {
      "throw NullPointerException" in {
        assertThrows[NullPointerException] {
          new Mainer(null, Array("")).either
        }
      }
    }
  }

  "A Mainer with IO and empty string in array" when {
    "invoke either" should {
      "return ProviderObject(Config())" in {
        val input = Streamer.toStream("")
        val output = new ByteArrayOutputStream()
        val params = Params(input, output)
        new Mainer(params, Array("")).either
        assert (Streamer.toString(output) == "")
      }
    }
  }

}
