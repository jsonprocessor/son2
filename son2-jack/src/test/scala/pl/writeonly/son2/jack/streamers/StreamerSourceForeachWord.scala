package pl.writeonly.son2.jack.streamers

import pl.writeonly.son2.jack.providers.ProviderFake
import pl.writeonly.son2.spec.WordFactory

import scala.io.Source

class StreamerSourceForeachWord extends WordFactory {

  "A StreamerSourceForeach" when {
    "convert empty two lines to String" should {
      "return ?" in {
        val streamer = new StreamerSourceForeach(new ProviderFake())
        streamer.source2string(Source.fromString("\n\n"))
      }
    }
    "convert empty two lines to pw" should {
      "return ?" in {
        val streamer = new StreamerSourceForeach(new ProviderFake())
        streamer.source2pw(Source.fromString("\n\n"), null)
      }
    }
  }
}
