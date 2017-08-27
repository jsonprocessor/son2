package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.chain.{ChainNotationRWT, PCreatorTranslatorFake}
import pl.writeonly.son2.path.core.{SmartPath, StrictPath}
import pl.writeonly.son2.path.creators._

class ChainNotationRWTPath extends ChainNotationRWT(
  (
    new PCreatorReaderPathQuery()
      orElse
      new PCreatorReaderPath(SmartPath())
      orElse
      new PCreatorReaderPath(StrictPath())
    ),
  (
    new PCreatorWriterPath(SmartPath())
      orElse
      new PCreatorWriterPath(StrictPath())
    ),
  new PCreatorTranslatorFake()
)
