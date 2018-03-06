package pl.writeonly.son2.jack.converters

import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.core.streamers.{Streamer, StreamerPipeForeach}
import pl.writeonly.son2.jack.core.{ConfigJack, FormatsJack}
import pl.writeonly.son2.jack.glue.CreatorConverterJack
import pl.writeonly.son2.spec.GrayVectorSpec

class ObjectVectorSpec extends GrayVectorSpec {

  val toSuccess = Table(
    ("in", "out"),
    ("0", "0"),
    ("\"a\"", "\"a\""),
    ("[]", "[ ]"),
    ("[0]", "[ 0 ]"),
    ("[0,1]", "[ 0, 1 ]"),
    ("{}", "{ }"),
    ("{\"a\":0}", "{\n  \"a\" : 0\n}"),
    ("{\"a\":0,\"b\":1}", "{\n  \"a\" : 0,\n  \"b\" : 1\n}"),
    ("[{}]", "[ { } ]"),
    ("{\"a\":[]}", "{\n  \"a\" : [ ]\n}")
  )

  val toFailure = Table("in", "a")

  val provider: Converter = CreatorConverterJack(
    ConfigJack(o = FormatsJack.OBJECT))
  property("convert son to json by provider") {
    forAll(toSuccess) { (in, out) =>
      provider.convert(in) should be(out)
    }
  }

  val liner: Liner = new LinerOpt(provider)
  property("convert son to json by liner") {
    forAll(toSuccess) { (in, out) =>
      liner.apply(in) should be(out + "\n")
    }
  }
  property("fail convert son to json by liner") {
    forAll(toFailure) { in =>
      liner.apply(in) should be(provider.comment(in) + "\n")
    }
  }

  val streamer: Streamer = new StreamerPipeForeach(liner)
  property("convert son to json by streamer") {
    forAll(toSuccess) { (in, out) =>
      streamer.convertString(in) should be(out + "\n")
    }
  }
  property("fail convert son to json by streamer") {
    forAll(toFailure) { in =>
      streamer.convertString(in) should be(provider.comment(in) + "\n")
    }
  }

  property("convert son to json by native streamer") {
    forAll(toSuccess) { (in, out) =>
      streamer.convertStringNative(in) should be(out + "\n")
    }
  }
  property("fail convert son to json by native streamer") {
    forAll(toFailure) { in =>
      streamer.convertStringNative(in) should be(provider.comment(in) + "\n")
    }
  }
}
