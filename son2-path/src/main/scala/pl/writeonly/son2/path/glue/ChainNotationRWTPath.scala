package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.chain.{ChainNotationRWT, PCreatorTranslatorFake}
import pl.writeonly.son2.path.creators._
import pl.writeonly.son2.path.notation.{NotationCaseGson, NotationCaseJson, NotationCaseSmart, NotationCaseStrict}

class ChainNotationRWTPath extends ChainNotationRWT(
  (
    new PCreatorReaderPathQuery()
      orElse
      new PCreatorReaderPath(NotationCaseGson())
      orElse
      new PCreatorReaderPath(NotationCaseJson())
      orElse
      new PCreatorReaderPath(NotationCaseSmart())
      orElse
      new PCreatorReaderPath(NotationCaseStrict())
    ),
  (
    new PCreatorWriterPath(NotationCaseGson())
      orElse
      new PCreatorWriterPath(NotationCaseJson())
      orElse
      new PCreatorWriterPath(NotationCaseSmart())
      orElse
      new PCreatorWriterPath(NotationCaseStrict())
    ),
  new PCreatorTranslatorFake()
)
