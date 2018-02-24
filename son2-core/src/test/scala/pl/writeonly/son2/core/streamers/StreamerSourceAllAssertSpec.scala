package pl.writeonly.son2.core.streamers

import java.io.{PrintWriter, StringWriter}

import pl.writeonly.son2.core.converters.ConverterFake
import pl.writeonly.son2.spec.WhiteAssertSpec

import scala.io.Source

class StreamerSourceAllAssertSpec extends WhiteAssertSpec {

  val EMPTY_STRING = ""
  val ONE_LINE = "\n"
  val TWO_LINE = "\n\n"
  val streamer: StreamerSource = new StreamerSourceAll(new ConverterFake)

  "A StreamerSourceAll" when {
    "convertStringNative empty string" should {
      "return empty string" in {
        assertResult(ONE_LINE)(streamer.convertStringNative(EMPTY_STRING))
      }
    }
    "convertString empty string" should {
      "return empty string" in {
        assertResult(ONE_LINE)(streamer.convertString(EMPTY_STRING))
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
