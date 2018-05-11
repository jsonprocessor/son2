package pl.writeonly.scallions.funs.streamers

import org.scalatest.Outcome
import pl.writeonly.scallions.apis.converters.ConverterFake
import pl.writeonly.scalaops.specs.fixture.WhiteAssertSpec
import pl.writeonly.scalaops.pipe.Pipe

class StreamerPipeAllAssertSpec extends WhiteAssertSpec with Pipe {

  override type FixtureParam = StreamerPipe

  override protected def withFixture(test: OneArgTest): Outcome =
    new StreamerPipeAll(new ConverterFake) |> test

  val EMPTY_STRING = ""
  val TWO_EMPTY_STRING = "\n"

  "A StreamerPipeAll" when {
    "convertStringNative empty string" should {
      "return empty string" in { streamer =>
        assertResult(TWO_EMPTY_STRING)(
          streamer.convertStringNative(EMPTY_STRING)
        )
      }
    }
    "convertString empty string" should {
      "return empty string" in { streamer =>
        assertResult(TWO_EMPTY_STRING)(streamer.convertString(EMPTY_STRING))
      }
    }
  }

}
