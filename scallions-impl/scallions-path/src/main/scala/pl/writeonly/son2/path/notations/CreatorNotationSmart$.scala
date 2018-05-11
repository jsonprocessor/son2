package pl.writeonly.son2.path.notations

import com.jayway.jsonpath.spi.json.JsonSmartJsonProvider
import com.jayway.jsonpath.spi.mapper.JsonSmartMappingProvider
import net.minidev.json.parser.JSONParser
import net.minidev.json.writer.JsonReaderI
import net.minidev.json.{JSONStyle, JSONValue}
import pl.writeonly.son2.apis.config.{Meta, RConfig, WConfig}
import pl.writeonly.son2.apis.core.Formats
import pl.writeonly.son2.apis.notation.{NotationWriter, Value}
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.path.notation.{CreatorNotation, NotationReaderPath}

trait CreatorNotationSmart extends CreatorNotation {

  override def reader(c: RConfig): NotationReaderPath =
    new NotationReaderSmart(c)

  override def writer(c: WConfig): NotationWriter = new NotationWriterSmart(c)

  class NotationReaderSmart(c: RConfig)
      extends NotationReaderPath(meta, defaultsPath(c)) {

    override def isDefinedAt(content: String): Boolean =
      JSONValue.isValidJson(content)
  }

  class NotationWriterSmart(c: WConfig) extends NotationWriter(meta, c) {

    override def writePretty(value: Value): String =
      JSONValue.toJSONString(value, JSONStyle.MAX_COMPRESS)

    override def writeRaw(value: Value): String =
      JSONValue.toJSONString(value, JSONStyle.NO_COMPRESS)
  }

}

object CreatorNotationSmart extends CreatorNotationSmart {
  val parseMode: Int = JSONParser.MODE_PERMISSIVE
  val mapper: JsonReaderI[_] = JSONValue.defaultReader.DEFAULT_ORDERED

  override def jsonProvider = new JsonSmartJsonProvider(parseMode, mapper)

  override def meta = Meta(ProvidersPath.SMART, Formats.OBJECT)

  override def mappingProvider = new JsonSmartMappingProvider(mapper.base)
}
