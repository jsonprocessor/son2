package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.notation.{NotationPair, PartialCreator, PartialCreatorPair}
import pl.writeonly.son2.path.notation.NotationReaderPath

class PartialCreatorPath extends PartialCreator {
  override def isDefinedAt(s: String) = s.startsWith("$")
  override def apply(path: String) = NotationPair(new NotationReaderPath(path), null)
}
