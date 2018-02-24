package pl.writeonly.son2.core.streamers

import java.io._
import java.net.URI
import java.nio.charset.StandardCharsets

import pl.writeonly.son2.core.converters.ConverterFake
import pl.writeonly.son2.spec.WhiteAssertSpec

import scala.io.Source

class StreamerSourceForeachAssertSpec extends WhiteAssertSpec {

  val EMPTY_STRING = ""
  val ONE_LINE = "\n"
  val TWO_LINE = "\n\n"
  val streamer = new StreamerSourceForeach(new ConverterFake)

  "A StreamerSourceForeach" when {
    val streamer = new StreamerSourceForeach(new ConverterFake())
    "convert empty two lines to String" should {
      "return ?" in {
        streamer.source2string(Source.fromString(TWO_LINE))
      }
    }
    "convert empty two lines to pw" should {
      "return ?" in {
        val writer = new StringWriter()
        streamer.source2pw(Source.fromString(TWO_LINE), new PrintWriter(writer))
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
    "convertStream empty string" should {
      "return empty string" in {
        val in = new ByteArrayInputStream(
          EMPTY_STRING.getBytes(StandardCharsets.UTF_8))
        val out = new ByteArrayOutputStream()
        streamer.convertStream(in, out)
        val bytes = out.toByteArray
        val string = new String(bytes, StandardCharsets.UTF_8)
        assertResult(EMPTY_STRING)(string)
      }
    }
  }

  "A StreamerSourceForeach" should {
    "produce NullPointerException when convertFile(File, File) is invoked" in {
      assertThrows[NullPointerException] {
        new StreamerSourceForeach(new ConverterFake())
          .convertFile(null.asInstanceOf[File], null.asInstanceOf[File])
      }
    }
    "produce NullPointerException when convertFile(URL, URL) is invoked" in {
      assertThrows[NullPointerException] {
        new StreamerSourceForeach(new ConverterFake())
          .convertFile(null.asInstanceOf[URI], null.asInstanceOf[URI])
      }
    }
    "produce NullPointerException when convertFile(String, String) is invoked" in {
      assertThrows[NullPointerException] {
        new StreamerSourceForeach(new ConverterFake())
          .convertFile(null.asInstanceOf[String], null.asInstanceOf[String])
      }
    }
  }
}
