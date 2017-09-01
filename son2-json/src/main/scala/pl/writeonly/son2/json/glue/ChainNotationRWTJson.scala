package pl.writeonly.son2.json.glue

import pl.writeonly.son2.core.chain.{ChainNotationRWT, PCreatorTranslatorFake}
import pl.writeonly.son2.jack.core.JackObject
import pl.writeonly.son2.jack.creators.{PCreatorReaderJack, PCreatorWriterJack}
import pl.writeonly.son2.json.creators.{PCreatorReaderGson, PCreatorReaderSmart, PCreatorWriterGson, PCreatorWriterSmart}

class ChainNotationRWTJson extends ChainNotationRWT(
  new PCreatorReaderJack(JackObject())
    orElse
    new PCreatorReaderGson()
    orElse
    new PCreatorReaderSmart(),
  new PCreatorWriterJack(JackObject())
    orElse
    new PCreatorWriterGson()
    orElse
    new PCreatorWriterSmart(),
  new PCreatorTranslatorFake()
)