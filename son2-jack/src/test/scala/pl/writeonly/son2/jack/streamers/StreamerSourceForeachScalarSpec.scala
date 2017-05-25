package pl.writeonly.son2.jack.streamers

import java.io.FileNotFoundException
import java.net.URI

import pl.writeonly.son2.jack.providers.ProviderFake
import pl.writeonly.son2.spec.GrayScalarSpec

class StreamerSourceForeachScalarSpec extends GrayScalarSpec {
  describe("A Streamer") {
    val streamer = new StreamerSourceForeach(new ProviderFake)
    it("when convertFile file with empty name") {
      assertThrows[FileNotFoundException] {
        streamer.convertFile("", "")
      }
    }
    it("when convertFile file with empty URI") {
      assertThrows[IllegalArgumentException] {
        streamer.convertFile(new URI(""), new URI(""))
      }
    }
  }
}
