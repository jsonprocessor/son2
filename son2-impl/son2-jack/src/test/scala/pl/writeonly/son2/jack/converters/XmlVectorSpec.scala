package pl.writeonly.son2.jack.converters

import pl.writeonly.son2.apis.converters.Converter
import pl.writeonly.son2.funs.liners.{Liner, LinerOpt}
import pl.writeonly.son2.funs.streamers.{Streamer, StreamerPipeForeach}
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.jack.glue.CreatorConverterJack
import pl.writeonly.sons.specs.GrayVectorSpec

class XmlVectorSpec extends GrayVectorSpec {

  val toSuccess = Table(
    ("in", "out"),
    ("0", "\n<IntNode>0</IntNode>"),
    ("\"a\"", "\n<TextNode>a</TextNode>"),
    ("[0]", "\n<ArrayNode>0</ArrayNode>"),
    ("{}", "<ObjectNode/>\n"),
    ("{\"a\":0}", "<ObjectNode>\n  <a>0</a>\n</ObjectNode>\n"),
    (
      "{\"a\":0, \"b\":1}",
      "<ObjectNode>\n  <a>0</a>\n  <b>1</b>\n</ObjectNode>\n"
    ),
    ("[{}]", "<ArrayNode/>\n"),
    ("{\"a\":[]}", "<ObjectNode/>\n")
  )

  val toFailure = Table("in", "a", "[]", "[0,1]")

  val provider: Converter = CreatorConverterJack(FormatsJack.XML)
  property("convert son to xml by provider") {
    forAll(toSuccess) { (in, out) =>
      provider.convert(in) should be(out)
    }
  }

  val liner: Liner = new LinerOpt(provider)
  property("convert son to xml by liner") {
    forAll(toSuccess) { (in, out) =>
      liner.apply(in) should be(out + "\n")
    }
  }
  property("fail convert son to xml by liner") {
    forAll(toFailure) { in =>
      liner.apply(in) should be(provider.comment(in) + "\n")
    }
  }

  val streamer: Streamer = new StreamerPipeForeach(liner)
  property("convert son to xml by streamer") {
    forAll(toSuccess) { (in, out) =>
      streamer.convertString(in) should be(out + "\n")
    }
  }
  property("fail convert son to xml by streamer") {
    forAll(toFailure) { in =>
      streamer.convertString(in) should be(provider.comment(in) + "\n")
    }
  }

  property("convert son to xml by native streamer") {
    forAll(toSuccess) { (in, out) =>
      streamer.convertStringNative(in) should be(out + "\n")
    }
  }
  property("fail convert son to xml by native streamer") {
    forAll(toFailure) { in =>
      streamer.convertStringNative(in) should be(provider.comment(in) + "\n")
    }
  }
}
