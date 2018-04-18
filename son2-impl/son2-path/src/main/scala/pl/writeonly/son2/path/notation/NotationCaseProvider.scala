package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JsonProvider
import pl.writeonly.son2.apis.config._
import pl.writeonly.son2.apis.notation.{NotationReader, NotationWriter, Value}
import pl.writeonly.son2.path.core.FDefaultsPath

abstract class NotationCaseProvider(meta: Meta, defaults: FDefaultsPath)
    extends NotationCasePath(
      meta,
      c => new NotationReaderPath(meta, defaults(c)),
      c => new NotationWriterProvider(meta, defaults(RConfig()).jsonProvider, c)
    )

class NotationReaderProvider(meta: Meta, provider: JsonProvider)
    extends NotationReader(meta) {
  override def apply(content: String): Value = provider.parse(content)
}

class NotationWriterProvider(meta: Meta, provider: JsonProvider, c: WConfig)
    extends NotationWriter(meta, c) {

  override def writePretty(value: Value): String = provider.toJson(value)

  override def writeRaw(value: Value): String = provider.toJson(value)

}
