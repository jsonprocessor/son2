package pl.writeonly.son2.funs.streamers

import java.io.{PrintWriter, StringWriter}

import org.scalatest.Outcome
import pl.writeonly.son2.apis.converters.ConverterFake
import pl.writeonly.sons.specs.fixture.WhiteAssertSpec
import pl.writeonly.addons.pipe.Pipe

import scala.io.Source

class StreamerSourceAllAssertSpec extends WhiteAssertSpec with Pipe {

  override type FixtureParam = StreamerSource

  override protected def withFixture(test: OneArgTest): Outcome =
    new StreamerSourceAll(new ConverterFake) |> test

  val EMPTY_STRING = ""
  val ONE_LINE = "\n"
  val TWO_LINE = "\n\n"

  "A StreamerSourceAll" when {
    "convertStringNative empty string" should {
      "return empty string" in { streamer =>
        assertResult(ONE_LINE)(streamer.convertStringNative(EMPTY_STRING))
      }
    }
    "convertString empty string" should {
      "return empty string" in { streamer =>
        assertResult(ONE_LINE)(streamer.convertString(EMPTY_STRING))
      }
    }
    "convert empty two lines to String" should {
      "return ?" in { streamer =>
        streamer.source2string(Source.fromString(TWO_LINE))
      }
    }
    "convert empty two lines to pw" should {
      "return ?" in { streamer =>
        val writer = new StringWriter()
        streamer.source2pw(Source.fromString(TWO_LINE), new PrintWriter(writer))
        print(writer.toString)
      }
    }
  }
}
