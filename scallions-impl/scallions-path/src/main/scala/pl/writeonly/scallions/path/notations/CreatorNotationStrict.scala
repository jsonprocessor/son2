package pl.writeonly.scallions.path.notations

import com.jayway.jsonpath.spi.json.JsonSmartJsonProvider
import com.jayway.jsonpath.spi.mapper.JsonSmartMappingProvider
import net.minidev.json.parser.JSONParser
import net.minidev.json.writer.JsonReaderI
import net.minidev.json.{JSONStyle, JSONValue}
import pl.writeonly.scallions.apis.config.{Meta, RConfig, WConfig}
import pl.writeonly.scallions.apis.core.Formats
import pl.writeonly.scallions.apis.notation.{NotationWriter, Value}
import pl.writeonly.scallions.path.core.ProvidersPath
import pl.writeonly.scallions.path.notation.NotationReaderPath

object CreatorNotationStrict extends CreatorNotationSmart {
  val meta = Meta(ProvidersPath.STRICT, Formats.OBJECT)

  val parseMode: Int = JSONParser.MODE_RFC4627

  val mapper: JsonReaderI[_] = JSONValue.defaultReader.DEFAULT

  override def jsonProvider = new JsonSmartJsonProvider(parseMode, mapper)

  override def reader(c: RConfig): NotationReaderPath =
    new NotationReaderStrict(c)

  override def writer(c: WConfig): NotationWriter = new NotationWriterStrict(c)

  class NotationReaderStrict(c: RConfig)
      extends NotationReaderPath(meta, defaultsPath(c)) {
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

  override def mappingProvider = new JsonSmartMappingProvider(mapper.base)
}
