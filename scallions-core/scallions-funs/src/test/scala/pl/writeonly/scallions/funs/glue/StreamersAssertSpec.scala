package pl.writeonly.scallions.funs.glue

import pl.writeonly.scallions.apis.config.RStyle.{RAll, RStream}
import pl.writeonly.scallions.funs.streamers.{StreamerPipeAll, StreamerPipeForeach, StreamerSourceAll, StreamerSourceForeach}
import pl.writeonly.scalaops.specs.WhiteAssertSpec
import pl.writeonly.scallions.funs.streamers.{StreamerPipeAll, StreamerSourceForeach}

class StreamersAssertSpec extends WhiteAssertSpec {

  "A Streamers" when {
    "s is true" should {
      val s = RStream
      "pipe return stream.isInstanceOf[StreamerPipeForeach]" in {
        val stream = Streamers.pipe(s, null)
        assert(stream.isInstanceOf[StreamerPipeForeach])
      }
      "source return stream.isInstanceOf[StreamerSourceForeach]" in {
        val stream = Streamers.source(s, null)
        assert(stream.isInstanceOf[StreamerSourceForeach])
      }
    }
    "s is false" should {
      val s = RAll
      "pipe return stream.isInstanceOf[StreamerPipeAll]" in {
        val stream = Streamers.pipe(s, null)
        assert(stream.isInstanceOf[StreamerPipeAll])
      }
      "source return stream.isInstanceOf[StreamerSourceAll]" in {
        val stream = Streamers.source(s, null)
        assert(stream.isInstanceOf[StreamerSourceAll])
      }
    }
  }
}
