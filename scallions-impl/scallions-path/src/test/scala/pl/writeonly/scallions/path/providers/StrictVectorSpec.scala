package pl.writeonly.scallions.path.providers

import pl.writeonly.scallions.apis.converters.Converter
import pl.writeonly.scallions.funs.liners.{Liner, LinerOpt}
import pl.writeonly.scallions.funs.streamers.StreamerPipeForeach
import pl.writeonly.scallions.path.core.{ConfigPath, ProvidersPath}
import pl.writeonly.scalaops.specs.GrayVectorSpec
import pl.writeonly.scallions.funs.streamers.Streamer
import pl.writeonly.scallions.path.chain.ChainNotationPairPath
import pl.writeonly.scallions.path.core.{ConfigPath, ProvidersPath}

class StrictVectorSpec extends GrayVectorSpec {

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

  val toFailure = Table("in", "a")
  val provider: Converter = ChainNotationPairPath(
    ConfigPath(provider = ProvidersPath.STRICT)
  ).get
  val liner: Liner = new LinerOpt(provider)
  property("convert son to smart by provider") {
    forAll(toSuccess) { (in, out) =>
      provider convert in shouldBe out
    }
  }
  val streamer: Streamer = new StreamerPipeForeach(liner)
  property("convert son to smart by liner") {
    forAll(toSuccess) { (in, out) =>
      liner.apply(in) should be(out + "\n")
    }
  }
  property("fail convert son to smart by liner") {
    forAll(toFailure) { in =>
      liner.apply(in) should be(provider.comment(in) + "\n")
    }
  }

  property("convert son to smart by streamer") {
    forAll(toSuccess) { (in, out) =>
      streamer.convertString(in) should be(out + "\n")
    }
  }
  property("fail convert son to smart by streamer") {
    forAll(toFailure) { in =>
      streamer.convertString(in) should be(provider.comment(in) + "\n")
    }
  }

  property("convert son to smart by native streamer") {
    forAll(toSuccess) { (in, out) =>
      streamer.convertStringNative(in) should be(out + "\n")
    }
  }
  property("fail convert son to smart by native streamer") {
    forAll(toFailure) { in =>
      streamer.convertStringNative(in) should be(provider.comment(in) + "\n")
    }
  }
}
