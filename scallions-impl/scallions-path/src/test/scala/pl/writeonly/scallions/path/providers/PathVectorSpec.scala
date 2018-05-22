package pl.writeonly.scallions.path.providers

import pl.writeonly.scalaops.specs.GrayVectorSpec
import pl.writeonly.scallions.apis.config.RPath
import pl.writeonly.scallions.apis.converters.Converter
import pl.writeonly.scallions.funs.liners.{Liner, LinerOpt}
import pl.writeonly.scallions.funs.streamers.{Streamer, StreamerPipeForeach}
import pl.writeonly.scallions.path.chain.ChainNotationPairPath
import pl.writeonly.scallions.path.core.ConfigPath

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
    ("{\"a\":[]}", "[[]]")
  )

  val toFailure = Table(("in", "out"), ("a", "[]"))

  val converter: Converter = ChainNotationPairPath(
    ConfigPath(q = RPath("$..*"))
  ).get
  property("convert son to smart by provider") {
    forAll(toSuccess) { (in, out) =>
      converter convert in shouldBe out
    }
  }

  val liner: Liner = new LinerOpt(converter)
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
