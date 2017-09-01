package pl.writeonly.son2.json.glue

import pl.writeonly.son2.core.chain.{ChainNotationRWT, PCreatorTranslatorFake}
import pl.writeonly.son2.jack.core.JackObject
import pl.writeonly.son2.jack.creators.{PCreatorReaderJack, PCreatorWriterJack}
import pl.writeonly.son2.json.creators.{PCreatorReaderGson, PCreatorWriterGson}

class ChainNotationRWTJson extends ChainNotationRWT(
  new PCreatorReaderJack(JackObject())
    orElse
    new PCreatorReaderGson(),
  new PCreatorWriterJack(JackObject())
    orElse
    new PCreatorWriterGson(),
  new PCreatorTranslatorFake()
)