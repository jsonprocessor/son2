package pl.writeonly.son2.path.providers

import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.liners.{ Liner, LinerOpt }
import pl.writeonly.son2.core.streamers.{ Streamer, StreamerPipeForeach }
import pl.writeonly.son2.path.chain.ChainNotationPairPath
import pl.writeonly.son2.path.core.ConfigPath
import pl.writeonly.son2.spec.GrayVectorSpec

class PathVectorSpec extends GrayVectorSpec {

  val toSuccess = Table(
    ("in", "out"),
    ("0", "[]"),
    ("\"a\"", "[]"),
    ("[]", "[]"),
    ("[0]", "[0]"),
    ("[0,1]", "[0,1]"),
    ("{}", "[]"),
    ("{\"a\":0}", "[0]"),
    ("{\"a\":0,\"b\":1}", "[0,1]"),
    ("[{}]", "[{}]"),
    ("{\"a\":[]}", "[[]]"))

  val toFailure = Table(("in", "out"), ("a", "[]"))

  val provider: Converter = ChainNotationPairPath(
    ConfigPath(q = Option("$..*")))
  property("convert son to smart by provider") {
    forAll(toSuccess) { (in, out) =>
      provider.convert(in) should be(out)
    }
  }

  val liner: Liner = new LinerOpt(provider)
  property("convert son to smart by liner") {
    forAll(toSuccess) { (in, out) =>
      liner.apply(in) should be(out + "\n")
    }
  }

  property("fail convert son to smart by liner") {
    forAll(toFailure) { (in, out) =>
      liner.apply(in) should be(out + "\n")
    }
  }

  val streamer: Streamer = new StreamerPipeForeach(liner)
  property("convert son to smart by streamer") {
    forAll(toSuccess) { (in, out) =>
      streamer.convertString(in) should be(out + "\n")
    }
  }

  property("fail convert son to smart by streamer") {
    forAll(toFailure) { (in, out) =>
      streamer.convertString(in) should be(out + "\n")
    }
  }

  property("convert son to smart by native streamer") {
    forAll(toSuccess) { (in, out) =>
      streamer.convertStringNative(in) should be(out + "\n")
    }
  }
  property("fail convert son to smart by native streamer") {
    forAll(toFailure) { (in, out) =>
      streamer.convertString(in) should be(out + "\n")
    }
  }
}
