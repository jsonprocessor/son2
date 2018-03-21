package pl.writeonly.son2.funs.glue

import pl.writeonly.son2.apis.config.{RAll, RStream}
import pl.writeonly.son2.funs.streamers.{
  StreamerPipeAll,
  StreamerPipeForeach,
  StreamerSourceAll,
  StreamerSourceForeach
}
import pl.writeonly.sons.specs.WhiteAssertSpec

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
