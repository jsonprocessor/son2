package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.config.RConfig
import pl.writeonly.son2.core.notation.NotationReader
import pl.writeonly.son2.core.pcreators.PCreatorReader
import pl.writeonly.son2.path.notation.NotationReaderPath

class PCreatorReaderPathMain extends PCreatorReader {

  override def isDefinedAt(c: RConfig): Boolean = isDefinedAt(c.query)

  def isDefinedAt(s: Option[String]): Boolean = s != null && s.isDefined && isDefinedAt(s.get)

  def isDefinedAt(s: String): Boolean = s != null && s.startsWith("$")

  override def apply(c: RConfig): NotationReader = new NotationReaderPath(c.query.get)
}
