package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JsonSmartJsonProvider
import net.minidev.json.{JSONStyle, JSONValue}
import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}
import pl.writeonly.son2.path.core.FormatsPath


case class NotationCaseStrict()
  extends NotationCasePath(FormatsPath.STRICT, new NotationReaderStrict, c => new NotationWriterStrict(c), new JsonSmartJsonProvider())

class NotationReaderStrict() extends NotationReader {
  def apply(content: String): Any = JSONValue.parseStrict(content)

  override def isDefinedAt(content: String): Boolean = JSONValue.isValidJsonStrict(content)
}

class NotationWriterStrict(c: WConfig) extends NotationWriter(c) {

  override def writePretty(value: Any): String = JSONValue.toJSONString(value, JSONStyle.MAX_COMPRESS)

  override def writeRaw(value: Any): String = JSONValue.toJSONString(value, JSONStyle.NO_COMPRESS)
}

