package pl.writeonly.son2.jack.providers

import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.core.streamers.{Streamer, StreamerPipeForeach}
import pl.writeonly.son2.core.glue.Config
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.spec.GrayVectorSpec
import pl.writeonly.son2.jack.glue.MatcherFormatProviderJack

class ObjectVectorSpec extends GrayVectorSpec {

  val toSuccess = Table(
    ("in", "out"),
    ("0", "0"),
    ("\"a\"", "\"a\""),
    ("[]", "[]"),
    ("[0]", "[0]"),
    ("[0,1]", "[0,1]"),
    ("{}", "{}"),
    ("{\"a\":0}", "{\"a\":0}"),
    ("{\"a\":0,\"b\":1}", "{\"a\":0,\"b\":1}"),
    ("[{}]", "[{}]"),
    ("{\"a\":[]}", "{\"a\":[]}")
  )

  val toFailure = Table(
    "in",
    "a"
  )

  val provider: Provider = MatcherFormatProviderJack(new Config(o = Formats.OBJECT, p = false))
  property("convert son to yaml by provider") {
    forAll(toSuccess) { (in, out) =>
      provider.convert(in) should be(out)
    }
  }

  val liner: Liner = new LinerOpt(provider)
  property("convert son to yaml by liner") {
    forAll(toSuccess) { (in, out) =>
      liner.apply(in) should be(out + "\n")
    }
  }
  property("fail convert son to yaml by liner") {
    forAll(toFailure) { in =>
      liner.apply(in) should be(provider.comment(in) + "\n")
    }
  }

  val streamer: Streamer = new StreamerPipeForeach(liner)
  property("convert son to yaml by streamer") {
    forAll(toSuccess) { (in, out) =>
      streamer.convertString(in) should be(out + "\n")
    }
  }
  property("fail convert son to yaml by streamer") {
    forAll(toFailure) { in =>
      streamer.convertString(in) should be(provider.comment(in) + "\n")
    }
  }

  property("convert son to yaml by native streamer") {
    forAll(toSuccess) { (in, out) =>
      streamer.convertStringNative(in) should be(out + "\n")
    }
  }
  property("fail convert son to yaml by native streamer") {
    forAll(toFailure) { in =>
      streamer.convertStringNative(in) should be(provider.comment(in) + "\n")
    }
  }
}
