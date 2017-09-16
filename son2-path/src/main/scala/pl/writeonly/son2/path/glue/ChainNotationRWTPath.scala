package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.chain.{ChainNotationRWT, PCreatorTranslatorFake}
import pl.writeonly.son2.path.creators._
import pl.writeonly.son2.path.notation._

class ChainNotationRWTPath extends ChainNotationRWT(
  (
    new PCreatorReaderPathMain()
      orElse
      new PCreatorReaderPath(NotationCaseGson())
      orElse
      new PCreatorReaderPath(NotationCaseJacksonType())
      orElse
      new PCreatorReaderPath(NotationCaseJacksonNode())
      orElse
      new PCreatorReaderPath(NotationCaseJettison())
      orElse
      new PCreatorReaderPath(NotationCaseOrgJson())
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
      new PCreatorWriterPath(NotationCaseJacksonType())
      orElse
      new PCreatorWriterPath(NotationCaseJacksonNode())
      orElse
      new PCreatorWriterPath(NotationCaseJettison())
      orElse
      new PCreatorWriterPath(NotationCaseOrgJson())
      orElse
      new PCreatorWriterPath(NotationCaseSmart())
      orElse
      new PCreatorWriterPath(NotationCaseStrict())
      orElse
      new PCreatorWriterPath(NotationCaseTapestry())
    ),
  new PCreatorTranslatorFake()
)
