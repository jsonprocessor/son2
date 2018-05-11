package pl.writeonly.scallions.path.notation

import com.jayway.jsonpath.spi.json.JsonProvider
import pl.writeonly.scallions.path.core.DefaultsPath
import pl.writeonly.scallions.apis.config._
import pl.writeonly.scallions.apis.notation.{NotationReader, NotationWriter, Value}

trait CreatorNotationProvider extends CreatorNotation {

  def defaultsPath(c: RConfig): DefaultsPath

  override def reader(c: RConfig) =
    new NotationReaderPath(meta, defaultsPath(c))

  override def writer(c: WConfig) =
    new NotationWriterProvider(meta, defaultsPath(RConfig()).jsonProvider, c)

  class NotationReaderProvider(meta: Meta, provider: JsonProvider)
      extends NotationReader(meta) {
    override def apply(content: String): Value = provider.parse(content)
  }

  class NotationWriterProvider(meta: Meta, provider: JsonProvider, c: WConfig)
      extends NotationWriter(meta, c) {

    override def writePretty(value: Value): String = provider.toJson(value)

    override def writeRaw(value: Value): String = provider.toJson(value)

  }

}
