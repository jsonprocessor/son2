package pl.writeonly.son2.jack.streams

import org.scalatest.WordSpec
import pl.writeonly.son2.jack.providers.ProviderImpl
import pl.writeonly.son2.jack.streamers.{Streamer, StreamerImplAll}

class StreamerImplAllWord extends WordSpec {

  val EMPTY_STRING = ""
  val TWO_EMPTY_STRING = "\n"
  val streamer: Streamer = new StreamerImplAll(new ProviderImpl)

  "A StreamerImplAll" when {
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
