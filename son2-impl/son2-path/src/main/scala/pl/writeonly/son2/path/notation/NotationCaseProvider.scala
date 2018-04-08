package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JsonProvider
import pl.writeonly.son2.apis.config._
import pl.writeonly.son2.apis.notation.{NotationReader, NotationWriter}
import pl.writeonly.son2.path.core.FDefaultsPath

abstract class NotationCaseProvider(format: ProviderType,
                                    meta: MetaLike,
                                    defaults: FDefaultsPath)
    extends NotationCasePath(
      format,
      c => new NotationReaderPath(meta, defaults(c)),
      c => new NotationWriterProvider(meta, defaults(RConfig()).jsonProvider, c)
    )

class NotationReaderProvider(meta: MetaLike, provider: JsonProvider)
    extends NotationReader(meta) {
  override def apply(content: String): Any = provider.parse(content)
}

class NotationWriterProvider(meta: MetaLike, provider: JsonProvider, c: WConfig)
    extends NotationWriter(meta, c) {

  override def writePretty(value: Any): String = provider.toJson(value)

  override def writeRaw(value: Any): String = provider.toJson(value)

}
