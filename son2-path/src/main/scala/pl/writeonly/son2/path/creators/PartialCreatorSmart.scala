package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.notation.{NotationPair, PartialCreator}
import pl.writeonly.son2.path.core.Formats
import pl.writeonly.son2.path.notation.{NotationReaderSmart, NotationWriterSmart}

class PartialCreatorSmart(pretty: Boolean) extends PartialCreator {
  override def isDefinedAt(s: String) = Formats.SMART.name.startsWith(s)
  override def apply(v1: String) = NotationPair(new NotationReaderSmart(), new NotationWriterSmart(pretty))
}
