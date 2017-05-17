package pl.writeonly.son2.main

import java.io.ByteArrayOutputStream

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.providers.ProviderFake
import pl.writeonly.son2.jack.streamers.Streamer
import pl.writeonly.son2.spec.WhiteSpec

class PiperWhite extends WhiteSpec {


  "A Piper" when {
    "convertStream from empty string" should {
      "return empty String" in {
        val input = Streamer.toStream("")
        val output = new ByteArrayOutputStream()
        val params = Params(null, output)
        val piper: Piper = new Piper(params, Config(), new ProviderFake())
        piper.convertStream(input)
        assert (Streamer.toString(output) == "")
      }
    }
    "convertStream from a string" should {
      "return a String" in {
        val input = Streamer.toStream("a")
        val output = new ByteArrayOutputStream()
        val params = Params(null, output)
        val piper: Piper = new Piper(params, Config(), new ProviderFake())
        piper.convertStream(input)
        assert (Streamer.toString(output) == "a\n")
      }
    }
  }
}
