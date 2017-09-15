package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JsonSmartJsonProvider
import com.jayway.jsonpath.spi.mapper.JsonSmartMappingProvider
import net.minidev.json.parser.JSONParser
import net.minidev.json.{JSONStyle, JSONValue}
import pl.writeonly.son2.core.config.{RConfig, WConfig}
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}
import pl.writeonly.son2.path.core.FormatsPath


case class NotationCaseStrict()
  extends NotationCasePath(FormatsPath.STRICT,
    c => new NotationReaderStrict(c),
    c => new NotationWriterStrict(c)
  )

class NotationReaderStrict(c:RConfig) extends NotationReaderPath(new DefaultsSmart(c, JSONParser.MODE_RFC4627, JSONValue.defaultReader.DEFAULT), c.query) {
  override def isDefinedAt(content: String): Boolean = JSONValue.isValidJsonStrict(content)
}

class NotationWriterStrict(c: WConfig) extends NotationWriter(c) {

  override def writePretty(value: Any): String = JSONValue.toJSONString(value, JSONStyle.MAX_COMPRESS)

  override def writeRaw(value: Any): String = JSONValue.toJSONString(value, JSONStyle.NO_COMPRESS)
}

