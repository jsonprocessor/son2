package pl.writeonly.son2.core.glue

import pl.writeonly.son2.core.streamers.{
  StreamerPipeAll,
  StreamerPipeForeach,
  StreamerSourceAll,
  StreamerSourceForeach
}
import pl.writeonly.son2.spec.WhiteResultSpec

class StreamersResultSpec extends WhiteResultSpec {

  "A Streamers" when {
    "s is true" should {
      val s = true
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
      val s = false
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
