package pl.writeonly.son2.main

import java.io.ByteArrayOutputStream

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.providers.ProviderFake
import pl.writeonly.son2.jack.streamers.Streamer
import pl.writeonly.son2.spec.WhiteResultSpec

class PiperResultSpec extends WhiteResultSpec {

  "A Piper" when {
    "convertStream from empty string" should {
      "return empty String" in {
        val input = Streamer.toStream("")
        val output = new ByteArrayOutputStream()
        val params = Params(null, output)
        val piper: Piper = new Piper(params, Config(), new ProviderFake())
        piper.convertStream(input)
        assertResult ("") (Streamer.toString(output))
      }
    }
    "convertStream from a string" should {
      "return a String" in {
        val input = Streamer.toStream("a")
        val output = new ByteArrayOutputStream()
        val params = Params(null, output)
        val piper: Piper = new Piper(params, Config(), new ProviderFake())
        piper.convertStream(input)
        assertResult ("a\n") (Streamer.toString(output))
      }
    }
  }
}
