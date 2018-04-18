package pl.writeonly.son2.path.notation

import net.minidev.json.parser.JSONParser
import net.minidev.json.{JSONStyle, JSONValue}
import pl.writeonly.son2.apis.config.{Meta, RConfig, WConfig}
import pl.writeonly.son2.apis.core.Formats
import pl.writeonly.son2.apis.notation.{NotationWriter, Value}
import pl.writeonly.son2.path.core.ProvidersPath

final case class NotationCaseStrict()
    extends NotationCasePath(
      Meta(ProvidersPath.STRICT, Formats.OBJECT),
      c => new NotationReaderStrict(c),
      c => new NotationWriterStrict(c)
    )

class NotationReaderStrict(c: RConfig)
    extends NotationReaderPath(
      Meta(ProvidersPath.STRICT, Formats.OBJECT),
      new DefaultsSmart(
        c,
        JSONParser.MODE_RFC4627,
        JSONValue.defaultReader.DEFAULT
      )
    ) {
  override def isDefinedAt(content: String): Boolean =
    JSONValue.isValidJsonStrict(content)
}

class NotationWriterStrict(c: WConfig)
    extends NotationWriter(Meta(ProvidersPath.STRICT, Formats.OBJECT), c) {

  override def writePretty(value: Value): String =
    JSONValue.toJSONString(value, JSONStyle.MAX_COMPRESS)

  override def writeRaw(value: Value): String =
    JSONValue.toJSONString(value, JSONStyle.NO_COMPRESS)
}
