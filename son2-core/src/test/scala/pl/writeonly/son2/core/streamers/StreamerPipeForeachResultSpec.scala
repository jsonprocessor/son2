package pl.writeonly.son2.core.streamers

import pl.writeonly.son2.core.converters.ConverterFake
import pl.writeonly.son2.spec.WhiteResultSpec

class StreamerPipeForeachResultSpec extends WhiteResultSpec {

  val EMPTY_STRING = ""
  val TWO_EMPTY_STRING = "\n"
  val streamer: Streamer = new StreamerPipeForeach(new ConverterFake)

  "A StreamerPipeForeach" when {
    "convertFile with empty File" should {
      "return empty File" in {
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
      "return empty string" in {
        assertResult(EMPTY_STRING)(streamer.convertStringNative(EMPTY_STRING))
      }
    }
    "convertString empty string" should {
      "return empty string" in {
        assertResult(EMPTY_STRING)(streamer.convertString(EMPTY_STRING))
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
