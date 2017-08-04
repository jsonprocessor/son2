package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.notation.{NotationPair, PartialCreator}
import pl.writeonly.son2.path.core.Formats
import pl.writeonly.son2.path.notation.NotationReaderPath

class PartialCreatorPath extends PartialCreator {

  override def isDefinedAt(s: String) = s != null && s.startsWith("$")

  override def apply(path: String) = NotationPair(c, new NotationReaderPath(path), null, null)

  def c(path: String) = new Config(i = path, o = Formats.STRICT.name, p = false)

}
