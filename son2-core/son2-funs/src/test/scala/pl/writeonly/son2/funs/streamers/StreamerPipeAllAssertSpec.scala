package pl.writeonly.son2.funs.streamers

import pl.writeonly.son2.apis.converters.ConverterFake
import pl.writeonly.son2.funs.streamers.Streamer
import pl.writeonly.sons.specs.WhiteAssertSpec

class StreamerPipeAllAssertSpec extends WhiteAssertSpec {

  val EMPTY_STRING = ""
  val TWO_EMPTY_STRING = "\n"
  val streamer: Streamer = new StreamerPipeAll(new ConverterFake)

  "A StreamerPipeAll" when {
    "convertStringNative empty string" should {
      "return empty string" in {
        assertResult(TWO_EMPTY_STRING)(
          streamer.convertStringNative(EMPTY_STRING)
        )
      }
    }
    "convertString empty string" should {
      "return empty string" in {
        assertResult(TWO_EMPTY_STRING)(streamer.convertString(EMPTY_STRING))
      }
    }
  }

}
