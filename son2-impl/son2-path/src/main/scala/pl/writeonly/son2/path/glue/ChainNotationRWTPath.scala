package pl.writeonly.son2.path.glue

import pl.writeonly.son2.apis.chain.{ChainNotationRWT, PCreatorTranslatorFake}
import pl.writeonly.son2.path.creators._
import pl.writeonly.son2.path.notations._

class ChainNotationRWTPath
    extends ChainNotationRWT(
      new PCreatorReaderPath(CreatorNotationGson())
        orElse
          new PCreatorReaderPath(CreatorNotationJackson())
        orElse
          new PCreatorReaderPath(CreatorNotationJacksonTyped())
        orElse
          new PCreatorReaderPath(CreatorNotationJettison())
        orElse
          new PCreatorReaderPath(CreatorNotationOrgJson())
        orElse
          new PCreatorReaderPath(CreatorNotationSmart())
        orElse
          new PCreatorReaderPath(CreatorNotationStrict())
        orElse
          new PCreatorReaderPath(CreatorNotationTapestry()),
      new PCreatorWriterPath(CreatorNotationGson())
        orElse
          new PCreatorWriterPath(CreatorNotationJackson())
        orElse
          new PCreatorWriterPath(CreatorNotationJacksonTyped())
        orElse
          new PCreatorWriterPath(CreatorNotationJettison())
        orElse
          new PCreatorWriterPath(CreatorNotationOrgJson())
        orElse
          new PCreatorWriterPath(CreatorNotationSmart())
        orElse
          new PCreatorWriterPath(CreatorNotationStrict())
        orElse
          new PCreatorWriterPath(CreatorNotationTapestry()),
      new PCreatorTranslatorFake()
    )
