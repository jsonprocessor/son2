package pl.writeonly.son2.jack.glue

import org.scalatest.WordSpec
import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.streamers.{StreamerPipeAll, StreamerPipeForeach, StreamerSourceAll, StreamerSourceForeach}
import pl.writeonly.son2.spec.WhiteSpec

class BuilderWord extends WhiteSpec {

  "A Builder" when {
    "config s is true" should {
      val builder = new Builder(Config(s = true))
      "return s equals true" in {
        val stream = builder.pipe
        assert(stream.isInstanceOf[StreamerPipeForeach])
      }
      "return p equals true" in {
        val stream = builder.source
        assert(stream.isInstanceOf[StreamerSourceForeach])
      }
    }
    "config s is false" should {
      val builder = new Builder(Config(s = false))
      "return i equals 'object'" in {
        val stream = builder.pipe
        assert(stream.isInstanceOf[StreamerPipeAll])
      }
      "return o equals 'yaml'" in {
        val stream = builder.source
        assert(stream.isInstanceOf[StreamerSourceAll])
      }
    }
  }
}
