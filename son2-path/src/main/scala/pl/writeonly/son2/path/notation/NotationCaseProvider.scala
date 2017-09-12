package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JsonProvider
import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}

abstract class NotationCaseProvider(
                                 format: Symbol,
                                 provider : JsonProvider
                               ) extends NotationCasePath(
  format,
  new NotationReaderProvider(provider),
  c => new NotationWriterProvider(provider, c),
  provider)

class NotationReaderProvider(provider : JsonProvider) extends NotationReader {
  override def apply(content: String): Any = provider.parse(content)
}

class NotationWriterProvider(provider : JsonProvider, c: WConfig)
  extends NotationWriter(c) {

  override def writePretty(value: Any): String = provider.toJson(value)

  override def writeRaw(value: Any): String = provider.toJson(value)

}
