package pl.writeonly.son2.path.providers

import pl.writeonly.son2.core.glue.ProviderCreator
import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.core.notation.Config
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.core.streamers.{Streamer, StreamerPipeForeach}
import pl.writeonly.son2.path.chain.ChainNotationPairPath
import pl.writeonly.son2.path.core.{ConfigPath, Formats}
import pl.writeonly.son2.spec.GrayVectorSpec

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

  val toFailure = Table(
    "in",
    "a"
  )
  val provider: Provider = ChainNotationPairPath(ConfigPath(Formats.STRICT))
  val liner: Liner = new LinerOpt(provider)
  property("convert son to smart by provider") {
    forAll(toSuccess) { (in, out) =>
      provider.convert(in) should be(out)
    }
  }
  val streamer: Streamer = new StreamerPipeForeach(liner)
  property("convert son to smart by liner") {
    forAll(toSuccess) { (in, out) =>
      liner.apply(in) should be(out + "\n")
    }
  }
  ignore("fail convert son to smart by liner") {
    forAll(toFailure) { in =>
      liner.apply(in) should be(provider.comment(in) + "\n")
    }
  }

  class ProviderCreatorPath(c: Config) extends ProviderCreator(c) {
    override def r = new ChainNotationPairPath(c.p)

    override def w = new ChainNotationPairPath(c.p)
  }

  property("convert son to smart by streamer") {
    forAll(toSuccess) { (in, out) =>
      streamer.convertString(in) should be(out + "\n")
    }
  }
  ignore("fail convert son to smart by streamer") {
    forAll(toFailure) { in =>
      streamer.convertString(in) should be(provider.comment(in) + "\n")
    }
  }

  property("convert son to smart by native streamer") {
    forAll(toSuccess) { (in, out) =>
      streamer.convertStringNative(in) should be(out + "\n")
    }
  }
  ignore("fail convert son to smart by native streamer") {
    forAll(toFailure) { in =>
      streamer.convertStringNative(in) should be(provider.comment(in) + "\n")
    }
  }
}
