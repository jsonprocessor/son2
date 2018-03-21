package pl.writeonly.son2.funs.streamers

import java.io.FileNotFoundException
import java.net.URI

import pl.writeonly.son2.apis.converters.ConverterFake
import pl.writeonly.sons.specs.GrayScalarSpec

class StreamerPipeForeachScalarSpec extends GrayScalarSpec {
  val streamer = new StreamerPipeForeach(new ConverterFake)

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
