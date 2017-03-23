package pl.writeonly.son2.core

import org.scalatest.FunSpec
import pl.writeonly.son2.core.providers.ProviderYaml
import pl.writeonly.son2.core.streamers.{Streamer, StreamerImpl}

class StreamerYamlFun extends FunSpec {
  describe("A FileJson2YamlSpec") {
    var onml: Streamer = new StreamerImpl(new ProviderYaml())

    describe("when left") {
      it("should produce null when consume null") {
        val yaml = onml.convertString(null)
        assert(null == yaml)
      }
      //      it("should produce empty comment when consume empty string") {
      //        val yaml = onml.apply("")
      //        assert("#" == yaml)
      //      }
      //      it("should produce a when consume a") {
      //        val yaml = onml.apply("a")
      //        assert("#a" == yaml)
      //      }
    }
  }
}
