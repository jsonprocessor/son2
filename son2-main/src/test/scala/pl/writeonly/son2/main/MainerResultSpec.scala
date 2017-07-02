package pl.writeonly.son2.main

import java.io.ByteArrayOutputStream

import pl.writeonly.son2.core.streamers.Streamer
import pl.writeonly.son2.spec.WhiteResultSpec

class MainerResultSpec extends WhiteResultSpec {

  "A Mainer with empty array" when {
    "invoke option" should {
      "return Left(None)" in {
        assertResult(Left(None))(new Mainer(null, Array()).option)
      }
    }
  }

  "A Mainer with README in array" when {
    "invoke option" should {
      "return Left(Option(readme)" in {
        assertResult(Left(Some("readme")))(new Mainer(null, Array("README")).option)
      }
    }
  }

  "A Mainer with empty string in array" when {
    "invoke option" should {
      "return ProviderObject(Config())" in {
        //        assertResult(Right(new ProviderObject(Config(o = ""))))(new Mainer(null, Array("")).option)
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
        assertResult("")(Streamer.toString(output))
      }
    }
  }

}
