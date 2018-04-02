package pl.writeonly.son2.funs.streamers

import java.io._
import java.net.URI
import java.nio.charset.StandardCharsets

import org.scalatest.Outcome
import pl.writeonly.son2.apis.converters.ConverterFake
import pl.writeonly.sons.specs.fixture.WhiteAssertSpec
import pl.writeonly.sons.utils.ops.Pipe

import scala.io.Source

class StreamerSourceForeachAssertSpec extends WhiteAssertSpec with Pipe {

  override type FixtureParam = StreamerSource

  override protected def withFixture(test: OneArgTest): Outcome =
    new StreamerSourceForeach(new ConverterFake) |> test

  val EMPTY_STRING = ""
  val ONE_LINE = "\n"
  val TWO_LINE = "\n\n"

  "A StreamerSourceForeach" when {
    "convert empty two lines to String" should {
      "return ?" in { streamer =>
        streamer.source2string(Source.fromString(TWO_LINE))
      }
    }
    "convert empty two lines to pw" should {
      "return ?" in { streamer =>
        val writer = new StringWriter()
        streamer.source2pw(Source.fromString(TWO_LINE), new PrintWriter(writer))
      }
    }
    "convertStringNative empty string" should {
      "return empty string" in { streamer =>
        assertResult(EMPTY_STRING)(streamer.convertStringNative(EMPTY_STRING))
      }
    }
    "convertString empty string" should {
      "return empty string" in { streamer =>
        assertResult(EMPTY_STRING)(streamer.convertString(EMPTY_STRING))
      }
    }
    "convertStream empty string" should {
      "return empty string" in { streamer =>
        val in = new ByteArrayInputStream(
          EMPTY_STRING.getBytes(StandardCharsets.UTF_8)
        )
        val out = new ByteArrayOutputStream()
        streamer.convertStream(in, out)
        val bytes = out.toByteArray
        val string = new String(bytes, StandardCharsets.UTF_8)
        assertResult(EMPTY_STRING)(string)
      }
    }
  }

  "A StreamerSourceForeach" should {
    "produce NullPointerException when convertFile(File, File) is invoked" in {
      streamer =>
        assertThrows[NullPointerException] {
          new StreamerSourceForeach(new ConverterFake())
            .convertFile(null.asInstanceOf[File], null.asInstanceOf[File])
        }
    }
    "produce NullPointerException when convertFile(URL, URL) is invoked" in {
      streamer =>
        assertThrows[NullPointerException] {
          new StreamerSourceForeach(new ConverterFake())
            .convertFile(null.asInstanceOf[URI], null.asInstanceOf[URI])
        }
    }
    "produce NullPointerException when convertFile(String, String) is invoked" in {
      streamer =>
        assertThrows[NullPointerException] {
          new StreamerSourceForeach(new ConverterFake())
            .convertFile(null.asInstanceOf[String], null.asInstanceOf[String])
        }
    }
  }
}
