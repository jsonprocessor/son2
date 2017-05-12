package pl.writeonly.son2.jack.streamers

import pl.writeonly.son2.jack.providers.ProviderFake
import pl.writeonly.son2.spec.WhiteSpec

class StreamerPipeAllWord extends WhiteSpec {

  val EMPTY_STRING = ""
  val TWO_EMPTY_STRING = "\n"
  val streamer: Streamer = new StreamerPipeAll(new ProviderFake)

  "A StreamerPipeAll" when {
    "convertStringNative empty string" should {
      "return empty string" in {
        assert (streamer.convertStringNative(EMPTY_STRING) == TWO_EMPTY_STRING)
      }
    }
    "convertString empty string" should {
      "return empty string" in {
        assert (streamer.convertString(EMPTY_STRING) == TWO_EMPTY_STRING)
      }
    }
  }

}
