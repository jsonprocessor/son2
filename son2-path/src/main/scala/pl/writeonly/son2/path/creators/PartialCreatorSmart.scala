package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.notation.{NotationPair, NotationReader, NotationWriter, PartialCreatorPair}
import pl.writeonly.son2.path.core.Formats
import pl.writeonly.son2.path.notation.{NotationReaderSmart, NotationWriterSmart}

class PartialCreatorSmart(pretty: Boolean) extends PartialCreatorPair {
  override def startsWith: Symbol = Formats.SMART

  override def r: NotationReader = new NotationReaderSmart()

  override def w: NotationWriter = new NotationWriterSmart(pretty)
}
