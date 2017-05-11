package pl.writeonly.son2.jack.streams

import java.io.{ByteArrayInputStream, ByteArrayOutputStream}
import java.nio.charset.StandardCharsets

import org.scalatest.WordSpec
import pl.writeonly.son2.jack.providers.ProviderFake
import pl.writeonly.son2.jack.streamers.{Streamer, StreamerSourceForeach}
import pl.writeonly.son2.spec.WordFactory

class StreamerSourceForeachWord extends WordFactory {

  val EMPTY_STRING = ""
  val TWO_EMPTY_STRING = "\n"
  val streamer: Streamer = new StreamerSourceForeach(new ProviderFake)

  "A StreamerSourceForeach" when {
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
