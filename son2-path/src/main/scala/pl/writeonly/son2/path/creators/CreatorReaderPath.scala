package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.notation.{CreatorReader}
import pl.writeonly.son2.path.notation.NotationReaderPath

class CreatorReaderPath extends CreatorReader {
  override def isDefinedAt(s: String) = s.startsWith("$")
  override def apply(path: String) = new NotationReaderPath(path)
}
