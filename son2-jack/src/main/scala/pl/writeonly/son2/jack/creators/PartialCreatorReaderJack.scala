package pl.writeonly.son2.jack.creators

import pl.writeonly.son2.core.config.RConfig
import pl.writeonly.son2.core.notation.NotationReader
import pl.writeonly.son2.core.pcreators.PCreatorReader
import pl.writeonly.son2.jack.core.Jack
import pl.writeonly.son2.jack.notation.NotationReaderJack

class PartialCreatorReaderJack(jack: Jack) extends PCreatorReader {
  override def isDefinedAt(c: RConfig): Boolean = jack.format.name.startsWith(c.format.name)

  override def apply(c: RConfig): NotationReader = new NotationReaderJack(jack.mapper)
}
