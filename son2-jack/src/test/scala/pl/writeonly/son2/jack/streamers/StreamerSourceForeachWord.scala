package pl.writeonly.son2.jack.streamers

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, PrintWriter, StringWriter}
import java.nio.charset.StandardCharsets

import pl.writeonly.son2.jack.providers.ProviderFake
import pl.writeonly.son2.spec.WordFactory

import scala.io.Source

class StreamerSourceForeachWord extends WordFactory {

  val EMPTY_STRING = ""
  val ONE_LINE = "\n"
  val TWO_LINE = "\n\n"
  val streamer = new StreamerSourceForeach(new ProviderFake)

  "A StreamerSourceForeach" when {
    val streamer = new StreamerSourceForeach(new ProviderFake())
    "convert empty two lines to String" should {
      "return ?" in {
        streamer.source2string(Source.fromString(TWO_LINE))
      }
    }
    "convert empty two lines to pw" should {
      "return ?" in {
        val writer = new StringWriter()
        streamer.source2pw(Source.fromString(TWO_LINE), new PrintWriter(writer))
      }
    }
    "convertStringNative empty string" should {
      "return empty string" in {
        assert (streamer.convertStringNative(EMPTY_STRING) == EMPTY_STRING)
      }
    }
    "convertString empty string" should {
      "return empty string" in {
        assert (streamer.convertString(EMPTY_STRING) == EMPTY_STRING)
      }
    }
    "convertStream empty string" should {
      "return empty string" in {
        val in = new ByteArrayInputStream(EMPTY_STRING.getBytes(StandardCharsets.UTF_8))
        val out = new ByteArrayOutputStream()
        streamer.convertStream(in, out)
        val bytes = out.toByteArray
        val string = new String(bytes, StandardCharsets.UTF_8)
        assert (string == EMPTY_STRING)
      }
    }
  }
}
