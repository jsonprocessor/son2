package pl.writeonly.son2.jack.streamers

import java.io.{PrintWriter, StringWriter}

import pl.writeonly.son2.jack.providers.ProviderFake
import pl.writeonly.son2.spec.WordFactory

import scala.io.Source

class StreamerSourceForeachWord extends WordFactory {

  "A StreamerSourceForeach" when {
    val streamer = new StreamerSourceForeach(new ProviderFake())
    "convert empty two lines to String" should {
      "return ?" in {
        streamer.source2string(Source.fromString("\n\n"))
      }
    }
    "convert empty two lines to pw" should {
      "return ?" in {
        val writer = new StringWriter()
        streamer.source2pw(Source.fromString("\n\n"), new PrintWriter(writer))
      }
    }
  }
}
