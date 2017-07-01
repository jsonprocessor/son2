package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.notation.PartialCreator
import pl.writeonly.son2.path.core.Formats
import pl.writeonly.son2.path.notation.{NotationReaderStrict, NotationWriterSmart, NotationWriterStrict}

class PartialCreatorStrict(pretty: Boolean) extends PartialCreator {
  override def isDefinedAt(s: String) = Formats.STRICT.name.startsWith(s)
  override def apply(v1: String) = (new NotationReaderStrict(), new NotationWriterStrict(pretty))
}
