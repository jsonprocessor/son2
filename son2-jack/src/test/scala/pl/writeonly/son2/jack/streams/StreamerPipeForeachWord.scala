package pl.writeonly.son2.jack.streams

import java.io.{ByteArrayInputStream, ByteArrayOutputStream, File}
import java.nio.charset.StandardCharsets

import org.scalatest.WordSpec
import pl.writeonly.son2.jack.providers.ProviderFake
import pl.writeonly.son2.jack.streamers.{Streamer, StreamerPipeForeach}
import org.scalamock.scalatest.MockFactory

class StreamerPipeForeachWord extends WordSpec with MockFactory {

  val EMPTY_STRING = ""
  val TWO_EMPTY_STRING = "\n"
  val streamer: Streamer = new StreamerPipeForeach(new ProviderFake)

  "A StreamerPipeForeach" when {
    "convertFile with empty File" should {
      "return empty File" in {
//        val in : File = stub[File]
//        val out : File = stub[File]
//        in.createNewFile returns true
//        in.isFile returns true
//        in.list returns Array("child1", "child2")
//        out.createNewFile returns true
//        out.isFile returns true
//        out.list returns Array("child1", "child2")
//        streamer.convertFile(in, out)
        //TODO assert it
      }
    }
    "convertStringNative empty string" should {
      "return empty string" in {
        assert (streamer.convertStringNative(EMPTY_STRING) == EMPTY_STRING)
      }
    }
    "convertString empty string" should {
      "return empty string" in {
        assert (streamer.convertString(EMPTY_STRING) == EMPTY_STRING)
      }
    }
//    "convertStream empty string" should {
//      "return empty string" in {
//        val in = new ByteArrayInputStream(EMPTY_STRING.getBytes(StandardCharsets.UTF_8))
//        val out = new ByteArrayOutputStream()
//        streamer.convertStream(in, out)
//        val bytes = out.toByteArray
//        val string = new String(bytes, StandardCharsets.UTF_8)
//        assert (string == EMPTY_STRING)
//      }
//    }
  }

}
