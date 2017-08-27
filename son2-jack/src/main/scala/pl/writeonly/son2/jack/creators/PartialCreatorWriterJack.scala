package pl.writeonly.son2.jack.creators

import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.notation.NotationWriter
import pl.writeonly.son2.core.pcreators.PCreatorWriter
import pl.writeonly.son2.jack.core.Jack
import pl.writeonly.son2.jack.notation.NotationWriterJack

class PartialCreatorWriterJack(jack: Jack) extends PCreatorWriter {
  override def isDefinedAt(c: WConfig): Boolean = jack.format.name.startsWith(c.format.name)

  override def apply(c: WConfig): NotationWriter = new NotationWriterJack(c, jack)
}
