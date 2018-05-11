package pl.writeonly.son2.path.creators

import pl.writeonly.son2.apis.config.WConfig
import pl.writeonly.son2.apis.notation.NotationWriter
import pl.writeonly.son2.apis.pcreators.PCreatorWriter
import pl.writeonly.son2.path.notation.NotationCasePath

class PCreatorWriterPath(path: NotationCasePath) extends PCreatorWriter {
  override def isDefinedAt(c: WConfig): Boolean =
    path.meta.providerType.startsWith(c.provider)

  override def apply(c: WConfig): NotationWriter = path.writer(c)
}
