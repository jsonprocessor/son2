package pl.writeonly.son2.path.creators

import pl.writeonly.son2.apis.config.RConfig
import pl.writeonly.son2.apis.notation.NotationReader
import pl.writeonly.son2.apis.pcreators.PCreatorReader
import pl.writeonly.son2.path.notation.NotationCasePath

class PCreatorReaderPath(jack: NotationCasePath) extends PCreatorReader {
  override def isDefinedAt(c: RConfig): Boolean =
    jack.format.startsWith(c.provider)

  override def apply(c: RConfig): NotationReader = jack.reader(c)
}
