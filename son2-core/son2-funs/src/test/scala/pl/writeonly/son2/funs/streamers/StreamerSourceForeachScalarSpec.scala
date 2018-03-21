package pl.writeonly.son2.funs.streamers

import java.io.FileNotFoundException
import java.net.URI

import pl.writeonly.son2.apis.converters.ConverterFake
import pl.writeonly.son2.funs.streamers.StreamerSource
import pl.writeonly.sons.specs.GrayScalarSpec

class StreamerSourceForeachScalarSpec extends GrayScalarSpec {

  val streamer: StreamerSource = new StreamerSourceForeach(new ConverterFake)
  it should "when convertFile file with empty name" in {
    assertThrows[FileNotFoundException] {
      streamer.convertFile("", "")
    }
  }
  it should "when convertFile file with empty URI" in {
    assertThrows[IllegalArgumentException] {
      streamer.convertFile(new URI(""), new URI(""))
    }
  }

}
