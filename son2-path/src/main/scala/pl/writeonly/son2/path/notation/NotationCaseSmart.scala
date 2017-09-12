package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JsonSmartJsonProvider
import net.minidev.json.{JSONStyle, JSONValue}
import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}
import pl.writeonly.son2.path.core.FormatsPath

case class NotationCaseSmart()
  extends NotationCasePath(FormatsPath.SMART, new NotationReaderSmart, c => new NotationWriterSmart(c), new JsonSmartJsonProvider())

class NotationReaderSmart() extends NotationReader {
  def apply(content: String): Any = JSONValue.parse(content)

  override def isDefinedAt(content: String): Boolean = JSONValue.isValidJson(content)
}

class NotationWriterSmart(c: WConfig) extends NotationWriter(c) {

  override def writePretty(value: Any): String = JSONValue.toJSONString(value, JSONStyle.MAX_COMPRESS)

  override def writeRaw(value: Any): String = JSONValue.toJSONString(value, JSONStyle.NO_COMPRESS)
}
