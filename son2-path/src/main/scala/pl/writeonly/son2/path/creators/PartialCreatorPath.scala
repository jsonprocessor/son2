package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.notation.PartialCreator
import pl.writeonly.son2.path.core.Formats
import pl.writeonly.son2.path.notation.NotationReaderPath

class PartialCreatorPath extends PartialCreator {

  override def isDefinedAt(s: String) = s != null && s.startsWith("$")

  override def c: (String) => Config = s => new Config(i = s, o = Formats.STRICT.name, p = false)

  override def r(s: String) = new NotationReaderPath(s)

}
