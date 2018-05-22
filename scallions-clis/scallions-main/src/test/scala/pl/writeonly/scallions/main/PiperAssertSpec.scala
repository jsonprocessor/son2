package pl.writeonly.scallions.main

import java.io.ByteArrayOutputStream

import pl.writeonly.scalaops.specs.WhiteAssertSpec
import pl.writeonly.scallions.apis.converters.ConverterFake
import pl.writeonly.scallions.funs.glue.{Params, Piper}
import pl.writeonly.scallions.funs.streamers.Streamer

class PiperAssertSpec extends WhiteAssertSpec {

  "A Piper" when {
    "convertStream from empty string" should {
      "return empty String" in {
        val input = Streamer.toStream("")
        val output = new ByteArrayOutputStream()
        val params = Params(null, output)
        val piper: Piper = new Piper(params, new ConverterFake())
        piper.convertStream(input)
        assertResult("")(Streamer.toString(output))
      }
    }
    "convertStream from a string" should {
      "return a String" in {
        val input = Streamer.toStream("a")
        val output = new ByteArrayOutputStream()
        val params = Params(null, output)
        val piper: Piper = new Piper(params, new ConverterFake())
        piper.convertStream(input)
        assertResult("a\n")(Streamer.toString(output))
      }
    }
  }
}
