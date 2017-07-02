package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter, PartialCreatorPair}
import pl.writeonly.son2.path.core.Formats
import pl.writeonly.son2.path.notation.{NotationReaderStrict, NotationWriterStrict}

class PartialCreatorStrict(pretty: Boolean) extends PartialCreatorPair {
  override def startsWith: Symbol = Formats.STRICT

  override def r: NotationReader = new NotationReaderStrict()

  override def w: NotationWriter = new NotationWriterStrict(pretty)
}
