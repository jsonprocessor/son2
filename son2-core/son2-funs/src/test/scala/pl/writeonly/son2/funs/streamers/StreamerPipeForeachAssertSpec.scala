package pl.writeonly.son2.funs.streamers

import java.io.File
import java.net.URI

import org.scalatest.Outcome
import pl.writeonly.son2.apis.converters.ConverterFake
import pl.writeonly.son2.funs.streamers.Streamer
import pl.writeonly.sons.specs.fixture.WhiteAssertSpec
import pl.writeonly.sons.utils.ops.Pipe

class StreamerPipeForeachAssertSpec extends WhiteAssertSpec with Pipe {

  override type FixtureParam = StreamerPipe

  override protected def withFixture(test: OneArgTest): Outcome =
    new StreamerPipeForeach(new ConverterFake) |> test

  val EMPTY_STRING = ""
  val TWO_EMPTY_STRING = "\n"

  "A StreamerPipeForeach" when {
    "convertFile with empty File" should {
      "return empty File" in { streamer =>
        //        val in : URL = mock[URL]
        //        val in : File = mock[File]
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
      "return empty string" in { streamer =>
        assertResult(EMPTY_STRING)(streamer.convertStringNative(EMPTY_STRING))
      }
    }
    "convertString empty string" should {
      "return empty string" in { streamer =>
        assertResult(EMPTY_STRING)(streamer.convertString(EMPTY_STRING))
      }
    }
    //    "convertStream empty string" should {
    //      "return empty string" in { streamer =>
    //        val in = new ByteArrayInputStream(EMPTY_STRING.getBytes(StandardCharsets.UTF_8))
    //        val out = new ByteArrayOutputStream()
    //        streamer.convertStream(in, out)
    //        val bytes = out.toByteArray
    //        val string = new String(bytes, StandardCharsets.UTF_8)
    //        assert (string == EMPTY_STRING)
    //      }
    //    }
  }

  "A StreamerPipeForeach" should {
    "produce NullPointerException when convertFile(File, File) is invoked" in {
      streamer =>
        assertThrows[NullPointerException] {
          new StreamerPipeForeach(new ConverterFake())
            .convertFile(null.asInstanceOf[File], null.asInstanceOf[File])
        }
    }
    "produce NullPointerException when convertFile(URL, URL) is invoked" in {
      streamer =>
        assertThrows[NullPointerException] {
          new StreamerPipeForeach(new ConverterFake())
            .convertFile(null.asInstanceOf[URI], null.asInstanceOf[URI])
        }

    }
    "produce NullPointerException when convertFile(String, String) is invoked" in {
      streamer =>
        assertThrows[NullPointerException] {
          new StreamerPipeForeach(new ConverterFake())
            .convertFile(null.asInstanceOf[String], null.asInstanceOf[String])
        }

    }
  }
}
