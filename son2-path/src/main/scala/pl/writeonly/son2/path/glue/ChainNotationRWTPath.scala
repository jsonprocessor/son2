package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.chain.{ChainNotationRWT, PCreatorTranslatorFake}
import pl.writeonly.son2.path.creators._
import pl.writeonly.son2.path.notation._

class ChainNotationRWTPath extends ChainNotationRWT(
  (

    new PCreatorReaderPath(NotationCaseGson())
      orElse
      new PCreatorReaderPath(NotationCaseJackson())
      orElse
      new PCreatorReaderPath(NotationCaseJacksonType())
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
      orElse
      new PCreatorReaderPathMain()
    ),
  (
    new PCreatorWriterPath(NotationCaseGson())
      orElse
      new PCreatorWriterPath(NotationCaseJackson())
      orElse
      new PCreatorWriterPath(NotationCaseJacksonType())
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
