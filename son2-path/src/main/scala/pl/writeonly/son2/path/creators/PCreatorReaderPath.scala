package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.config.RConfig
import pl.writeonly.son2.core.notation.NotationReader
import pl.writeonly.son2.core.pcreators.PCreatorReader
import pl.writeonly.son2.path.notation.NotationCasePath

class PCreatorReaderPath(jack: NotationCasePath) extends PCreatorReader {
  override def isDefinedAt(c: RConfig): Boolean = jack.format.name.startsWith(c.format.name)

  override def apply(c: RConfig): NotationReader = jack.reader
}
