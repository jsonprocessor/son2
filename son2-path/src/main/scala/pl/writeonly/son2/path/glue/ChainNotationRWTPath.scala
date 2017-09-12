package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.chain.{ChainNotationRWT, PCreatorTranslatorFake}
import pl.writeonly.son2.path.creators._
import pl.writeonly.son2.path.notation._

class ChainNotationRWTPath extends ChainNotationRWT(
  (
    new PCreatorReaderPathQuery()
      orElse
      new PCreatorReaderPath(NotationCaseGson())
      orElse
      new PCreatorReaderPath(NotationCaseJackson())
      orElse
      new PCreatorReaderPath(NotationCaseNode())
      orElse
      new PCreatorReaderPath(NotationCaseJettison())
      orElse
      new PCreatorReaderPath(NotationCaseJson())
      orElse
      new PCreatorReaderPath(NotationCaseSmart())
      orElse
      new PCreatorReaderPath(NotationCaseStrict())
      orElse
      new PCreatorReaderPath(NotationCaseTapestry())
    ),
  (
    new PCreatorWriterPath(NotationCaseGson())
      orElse
      new PCreatorWriterPath(NotationCaseJackson())
      orElse
      new PCreatorWriterPath(NotationCaseNode())
      orElse
      new PCreatorWriterPath(NotationCaseJettison())
      orElse
      new PCreatorWriterPath(NotationCaseJson())
      orElse
      new PCreatorWriterPath(NotationCaseSmart())
      orElse
      new PCreatorWriterPath(NotationCaseStrict())
      orElse
      new PCreatorWriterPath(NotationCaseTapestry())
    ),
  new PCreatorTranslatorFake()
)
