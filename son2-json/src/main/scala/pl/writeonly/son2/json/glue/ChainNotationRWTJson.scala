package pl.writeonly.son2.json.glue

import pl.writeonly.son2.core.chain.{ChainNotationRWT, PCreatorTranslatorFake}
import pl.writeonly.son2.jack.core.JackObject
import pl.writeonly.son2.jack.creators.{PCreatorReaderJack, PCreatorWriterJack}
import pl.writeonly.son2.json.creators.{PCreatorReaderSmart, PCreatorWriterSmart}
import pl.writeonly.son2.path.core.{SmartPath, StrictPath}
import pl.writeonly.son2.path.creators.{PCreatorReaderGson, PCreatorReaderPath, PCreatorWriterGson, PCreatorWriterPath}

class ChainNotationRWTJson extends ChainNotationRWT(
  new PCreatorReaderPath(SmartPath())
    orElse
    new PCreatorReaderPath(StrictPath())
    orElse
    new PCreatorReaderGson()
    orElse
    new PCreatorReaderJack(JackObject()),
  new PCreatorWriterPath(SmartPath())
    orElse
    new PCreatorWriterPath(StrictPath())
    orElse
    new PCreatorWriterGson()
    orElse
    new PCreatorWriterJack(JackObject()),
  new PCreatorTranslatorFake()
)