package pl.writeonly.son2.path.creators

import pl.writeonly.son2.apis.config.RConfig
import pl.writeonly.son2.apis.notation.NotationReaderLike
import pl.writeonly.son2.apis.pcreators.PCreatorReader
import pl.writeonly.son2.path.notation.NotationCasePath

class PCreatorReaderPath(jack: NotationCasePath) extends PCreatorReader {
  override def isDefinedAt(c: RConfig): Boolean =
    jack.provider.startsWith(c.provider)

  override def apply(c: RConfig): NotationReaderLike = jack.reader(c)
}
