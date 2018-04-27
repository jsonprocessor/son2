package pl.writeonly.son2.funs.streamers

import org.scalatest.Outcome
import pl.writeonly.son2.apis.converters.ConverterFake
import pl.writeonly.sons.specs.fixture.WhiteAssertSpec
import pl.writeonly.addons.pipe.Pipe

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
