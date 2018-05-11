package pl.writeonly.scallions.path.creators

import pl.writeonly.scallions.path.notation.NotationCasePath
import pl.writeonly.scallions.apis.config.WConfig
import pl.writeonly.scallions.apis.notation.NotationWriter
import pl.writeonly.scallions.apis.chain.PCreatorWriter
import pl.writeonly.scallions.path.notation.NotationCasePath

class PCreatorWriterPath(path: NotationCasePath) extends PCreatorWriter {
  override def isDefinedAt(c: WConfig): Boolean =
    path.meta.providerType.startsWith(c.provider)

  override def apply(c: WConfig): NotationWriter = path.writer(c)
}
