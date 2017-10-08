package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.notation.NotationWriter
import pl.writeonly.son2.core.pcreators.PCreatorWriter
import pl.writeonly.son2.path.notation.NotationCasePath

class PCreatorWriterPath(path: NotationCasePath) extends PCreatorWriter {
  override def isDefinedAt(c: WConfig): Boolean = path.format.name.startsWith(c.provider.name)

  override def apply(c: WConfig): NotationWriter = path.writer(c)
}
