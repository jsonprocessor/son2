package pl.writeonly.son2.main

import java.io.ByteArrayOutputStream

import org.scalactic.Bad
import pl.writeonly.son2.core.glue.Params
import pl.writeonly.son2.core.streamers.Streamer
import pl.writeonly.son2.spec.WhiteAssertSpec

class MainerAssertSpec extends WhiteAssertSpec {

  "A Mainer with empty array" when {
    "invoke option" should {
      "return Bad(Null)" in {
        assertResult(Bad(""))(new Mainer(null, Array()).option)
      }
    }
  }

  "A Mainer with empty string in array" when {
    "invoke either" should {
      "throw NullPointerException" in {
        assertThrows[NullPointerException] {
          new Mainer(null, Array("")).apply
        }
      }
    }
  }

  "A Mainer with IO and empty string in array" when {
    "invoke either" should {
      "return ConverterObject(Config())" in {
        val input = Streamer.toStream("")
        val output = new ByteArrayOutputStream()
        val params = Params(input, output)
        new Mainer(params, Array("")).apply
        assertResult("")(Streamer.toString(output))
      }
    }
  }

}
