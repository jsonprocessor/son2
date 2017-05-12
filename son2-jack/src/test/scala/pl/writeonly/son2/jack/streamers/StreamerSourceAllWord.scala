package pl.writeonly.son2.jack.streamers

import java.io.{PrintWriter, StringWriter}

import pl.writeonly.son2.jack.providers.ProviderFake
import pl.writeonly.son2.spec.WordFactory

import scala.io.Source

class StreamerSourceAllWord extends WordFactory {

  val string = "\n\n"
  "A StreamerSourceAll" when {
    val streamer = new StreamerSourceAll(new ProviderFake())
    "convert empty two lines to String" should {
      "return ?" in {
        streamer.source2string(Source.fromString(string))
      }
    }
    "convert empty two lines to pw" should {
      "return ?" in {
        val writer = new StringWriter()
        streamer.source2pw(Source.fromString(string), new PrintWriter(writer))
        print(writer.toString)
      }
    }
  }
}
