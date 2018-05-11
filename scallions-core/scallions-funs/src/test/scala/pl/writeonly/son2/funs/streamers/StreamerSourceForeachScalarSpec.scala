package pl.writeonly.son2.funs.streamers

import java.io.FileNotFoundException
import java.net.URI

import org.scalatest.Outcome
import pl.writeonly.son2.apis.converters.ConverterFake
import pl.writeonly.scalaops.specs.fixture.GrayScalarSpec
import pl.writeonly.scalaops.pipe.Pipe

class StreamerSourceForeachScalarSpec extends GrayScalarSpec with Pipe {

  override type FixtureParam = StreamerSource

  override protected def withFixture(test: OneArgTest): Outcome =
    new StreamerSourceForeach(new ConverterFake) |> test

  it should "when convertFile file with empty name" in { streamer =>
    assertThrows[FileNotFoundException] {
      streamer.convertFile("", "")
    }
  }
  it should "when convertFile file with empty URI" in { streamer =>
    assertThrows[IllegalArgumentException] {
      streamer.convertFile(new URI(""), new URI(""))
    }
  }

}
