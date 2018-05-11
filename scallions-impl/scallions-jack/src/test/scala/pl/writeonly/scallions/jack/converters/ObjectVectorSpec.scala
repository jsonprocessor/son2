package pl.writeonly.scallions.jack.converters

import pl.writeonly.scallions.apis.converters.Converter
import pl.writeonly.scallions.funs.liners.{Liner, LinerOpt}
import pl.writeonly.scallions.funs.streamers.StreamerPipeForeach
import pl.writeonly.scallions.jack.core.{ConfigJack, FormatsJack}
import pl.writeonly.scalaops.specs.GrayVectorSpec
import pl.writeonly.scallions.funs.streamers.Streamer
import pl.writeonly.scallions.jack.core.{ConfigJack, FormatsJack}
import pl.writeonly.scallions.jack.glue.CreatorConverterJack

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

  val converter: Converter = CreatorConverterJack(
    ConfigJack(o = FormatsJack.OBJECT)
  ).get
  property("convert son to json by provider") {
    forAll(toSuccess) { (in, out) =>
      converter convert in shouldBe out
    }
  }

  val liner: Liner = new LinerOpt(converter)
  property("convert son to json by liner") {
    forAll(toSuccess) { (in, out) =>
      liner.apply(in) should be(out + "\n")
    }
  }
  property("fail convert son to json by liner") {
    forAll(toFailure) { in =>
      liner.apply(in) should be(converter.comment(in) + "\n")
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
      streamer.convertString(in) should be(converter.comment(in) + "\n")
    }
  }

  property("convert son to json by native streamer") {
    forAll(toSuccess) { (in, out) =>
      streamer.convertStringNative(in) should be(out + "\n")
    }
  }
  property("fail convert son to json by native streamer") {
    forAll(toFailure) { in =>
      streamer.convertStringNative(in) should be(converter.comment(in) + "\n")
    }
  }
}
