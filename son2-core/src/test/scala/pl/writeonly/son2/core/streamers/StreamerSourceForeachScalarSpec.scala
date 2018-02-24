package pl.writeonly.son2.core.streamers

import java.io.FileNotFoundException
import java.net.URI

import pl.writeonly.son2.core.converters.ConverterFake
import pl.writeonly.son2.spec.GrayScalarSpec

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
