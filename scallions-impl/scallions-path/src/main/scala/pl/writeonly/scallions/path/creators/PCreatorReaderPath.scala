package pl.writeonly.scallions.path.creators

import pl.writeonly.scallions.apis.chain.PCreatorReader
import pl.writeonly.scallions.apis.config.RConfig
import pl.writeonly.scallions.apis.notation.NotationReader
import pl.writeonly.scallions.path.notation.NotationCasePath

class PCreatorReaderPath(jack: NotationCasePath) extends PCreatorReader {
  override def isDefinedAt(c: RConfig): Boolean =
    jack.meta.providerType.startsWith(c.provider)

  override def apply(c: RConfig): NotationReader = jack.reader(c)
}
