package pl.writeonly.son2.jack.streamers

import java.io.{PrintWriter, StringWriter}

import pl.writeonly.son2.jack.providers.ProviderFake
import pl.writeonly.son2.spec.WordFactory

import scala.io.Source

class StreamerSourceAllWord extends WordFactory {

  val EMPTY_STRING = ""
  val ONE_LINE = "\n"
  val TWO_LINE = "\n\n"
  val streamer = new StreamerSourceAll(new ProviderFake)

  "A StreamerSourceAll" when {
    "convertStringNative empty string" should {
      "return empty string" in {
        assert (streamer.convertStringNative(EMPTY_STRING) == ONE_LINE)
      }
    }
    "convertString empty string" should {
      "return empty string" in {
        assert (streamer.convertString(EMPTY_STRING) == ONE_LINE)
      }
    }
    "convert empty two lines to String" should {
      "return ?" in {
        streamer.source2string(Source.fromString(TWO_LINE))
      }
    }
    "convert empty two lines to pw" should {
      "return ?" in {
        val writer = new StringWriter()
        streamer.source2pw(Source.fromString(TWO_LINE), new PrintWriter(writer))
        print(writer.toString)
      }
    }
  }
}
