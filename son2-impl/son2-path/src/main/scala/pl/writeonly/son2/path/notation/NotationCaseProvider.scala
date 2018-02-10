package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JsonProvider
import pl.writeonly.son2.core.config.{RConfig, WConfig}
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}
import pl.writeonly.son2.path.core.FDefaultsPath

abstract class NotationCaseProvider(format: Symbol, defaults: FDefaultsPath)
    extends NotationCasePath(
      format,
      c => new NotationReaderPath(defaults(c)),
      c => new NotationWriterProvider(defaults(RConfig()).jsonProvider(), c))

class NotationReaderProvider(provider: JsonProvider) extends NotationReader {
  override def apply(content: String): Any = provider.parse(content)
}

class NotationWriterProvider(provider: JsonProvider, c: WConfig)
    extends NotationWriter(c) {

  override def writePretty(value: Any): String = provider.toJson(value)

  override def writeRaw(value: Any): String = provider.toJson(value)

}
