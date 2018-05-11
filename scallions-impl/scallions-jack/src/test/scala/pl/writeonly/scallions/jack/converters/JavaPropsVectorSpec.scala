package pl.writeonly.scallions.jack.converters

import pl.writeonly.scallions.apis.converters.Converter
import pl.writeonly.scallions.funs.liners.{Liner, LinerOpt}
import pl.writeonly.scallions.funs.streamers.StreamerPipeForeach
import pl.writeonly.scallions.jack.core.FormatsJack
import pl.writeonly.scalaops.specs.GrayVectorSpec
import pl.writeonly.scallions.funs.streamers.Streamer
import pl.writeonly.scallions.jack.core.FormatsJack
import pl.writeonly.scallions.jack.glue.CreatorConverterJack

class JavaPropsVectorSpec extends GrayVectorSpec {

  val toSuccess = Table(
    ("in", "out"),
    ("0", "=0\n"),
    ("\"a\"", "=a\n"),
    ("[]", ""),
    ("[0]", "1=0\n"),
    ("[0,1]", "1=0\n2=1\n"),
    ("{}", ""),
    ("{\"a\":0}", "a=0\n"),
    ("{\"a\":0, \"b\":1}", "a=0\nb=1\n"),
    ("[{}]", ""),
    ("{\"a\":[]}", "")
  )

  val toFailure = Table("in", "a")

  val converter: Converter = CreatorConverterJack(FormatsJack.JAVA_PROPS).get
  property("convert son to yaml by provider") {
    forAll(toSuccess) { (in, out) =>
      converter convert in shouldBe out
    }
  }

  val liner: Liner = new LinerOpt(converter)
  property("convert son to yaml by liner") {
    forAll(toSuccess) { (in, out) =>
      liner.apply(in) should be(out + "\n")
    }
  }
  property("fail convert son to yaml by liner") {
    forAll(toFailure) { in =>
      liner.apply(in) should be(converter.comment(in) + "\n")
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
      streamer.convertString(in) should be(converter.comment(in) + "\n")
    }
  }

  property("convert son to yaml by native streamer") {
    forAll(toSuccess) { (in, out) =>
      streamer.convertStringNative(in) should be(out + "\n")
    }
  }
  property("fail convert son to yaml by native streamer") {
    forAll(toFailure) { in =>
      streamer.convertStringNative(in) should be(converter.comment(in) + "\n")
    }
  }
}
