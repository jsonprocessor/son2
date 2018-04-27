package pl.writeonly.son2.funs.streamers

import java.io.FileNotFoundException
import java.net.URI

import org.scalatest.Outcome
import pl.writeonly.son2.apis.converters.ConverterFake
import pl.writeonly.sons.specs.fixture.GrayScalarSpec
import pl.writeonly.addons.pipe.Pipe

class StreamerPipeForeachScalarSpec extends GrayScalarSpec with Pipe {

  override type FixtureParam = StreamerPipe

  override protected def withFixture(test: OneArgTest): Outcome =
    new StreamerPipeForeach(new ConverterFake) |> test

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
