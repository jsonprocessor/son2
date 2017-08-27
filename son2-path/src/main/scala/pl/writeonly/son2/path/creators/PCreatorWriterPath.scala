package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.notation.NotationWriter
import pl.writeonly.son2.core.pcreators.PCreatorWriter
import pl.writeonly.son2.path.core.Path

class PCreatorWriterPath(path: Path) extends PCreatorWriter {
  override def isDefinedAt(c: WConfig): Boolean = path.format.name.startsWith(c.format.name)

  override def apply(c: WConfig): NotationWriter = path.writer(c)
}
