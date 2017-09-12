package pl.writeonly.son2.json.glue

import pl.writeonly.son2.core.chain.{ChainNotationRWT, PCreatorTranslatorFake}
import pl.writeonly.son2.jack.core.JackObject
import pl.writeonly.son2.jack.creators.{PCreatorReaderJack, PCreatorWriterJack}
import pl.writeonly.son2.path.creators.{PCreatorReaderGson, PCreatorReaderPath, PCreatorWriterGson, PCreatorWriterPath}
import pl.writeonly.son2.path.notation.{NotationCaseSmart, NotationCaseStrict}

class ChainNotationRWTJson extends ChainNotationRWT(
  new PCreatorReaderPath(NotationCaseSmart())
    orElse
    new PCreatorReaderPath(NotationCaseStrict())
    orElse
    new PCreatorReaderGson()
    orElse
    new PCreatorReaderJack(JackObject()),
  new PCreatorWriterPath(NotationCaseSmart())
    orElse
    new PCreatorWriterPath(NotationCaseStrict())
    orElse
    new PCreatorWriterGson()
    orElse
    new PCreatorWriterJack(JackObject()),
  new PCreatorTranslatorFake()
)