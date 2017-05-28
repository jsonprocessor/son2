package pl.writeonly.son2.jack.streamers

import pl.writeonly.son2.jack.providers.ProviderFake
import pl.writeonly.son2.spec.WhiteResultSpec

class StreamerPipeAllResultSpec extends WhiteResultSpec {

  val EMPTY_STRING = ""
  val TWO_EMPTY_STRING = "\n"
  val streamer: Streamer = new StreamerPipeAll(new ProviderFake)

  "A StreamerPipeAll" when {
    "convertStringNative empty string" should {
      "return empty string" in {
        assertResult(TWO_EMPTY_STRING)(streamer.convertStringNative(EMPTY_STRING))
      }
    }
    "convertString empty string" should {
      "return empty string" in {
        assertResult(TWO_EMPTY_STRING)(streamer.convertString(EMPTY_STRING))
      }
    }
  }

}
