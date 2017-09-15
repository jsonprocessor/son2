package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JsonSmartJsonProvider
import com.jayway.jsonpath.spi.mapper.JsonSmartMappingProvider
import net.minidev.json.parser.JSONParser
import net.minidev.json.writer.JsonReaderI
import net.minidev.json.{JSONStyle, JSONValue}
import pl.writeonly.son2.core.config.{RConfig, WConfig}
import pl.writeonly.son2.core.notation.NotationWriter
import pl.writeonly.son2.path.core.{DefaultsPath, FormatsPath}

case class NotationCaseSmart()
  extends NotationCasePath(FormatsPath.SMART,
    c => new NotationReaderSmart(c),
    c => new NotationWriterSmart(c))


class DefaultsSmart(c: RConfig, parseMode: Int, mapper: JsonReaderI[_])
  extends DefaultsPath(c, new JsonSmartJsonProvider(parseMode, mapper), new JsonSmartMappingProvider(mapper.base)) {
  def this(c: RConfig) = this(c, JSONParser.MODE_PERMISSIVE, JSONValue.defaultReader.DEFAULT_ORDERED)
}

class NotationReaderSmart(c: RConfig) extends NotationReaderPath(new DefaultsSmart(c)) {

  override def isDefinedAt(content: String): Boolean = JSONValue.isValidJson(content)
}

class NotationWriterSmart(c: WConfig) extends NotationWriter(c) {

  override def writePretty(value: Any): String = JSONValue.toJSONString(value, JSONStyle.MAX_COMPRESS)

  override def writeRaw(value: Any): String = JSONValue.toJSONString(value, JSONStyle.NO_COMPRESS)
}
