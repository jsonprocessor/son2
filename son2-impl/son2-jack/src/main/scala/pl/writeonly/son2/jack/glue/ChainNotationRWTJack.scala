package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.apis.chain.{ChainNotationRWT, PCreatorTranslatorFake}
import pl.writeonly.son2.jack.core._
import pl.writeonly.son2.jack.creators.{PCreatorReaderJack, PCreatorWriterJack}

class ChainNotationRWTJack
    extends ChainNotationRWT(
      (new PCreatorReaderJack(MetaJackObject())
        orElse
          new PCreatorReaderJack(MetaJackXml())
        orElse
          new PCreatorReaderJack(MetaJackYaml())
        orElse
          new PCreatorReaderJack(MetaJackCsv())
        orElse
          new PCreatorReaderJack(MetaJackProperties())
        orElse
          new PCreatorReaderJack(MetaJackJavaProps())),
      (new PCreatorWriterJack(MetaJackObject())
        orElse
          new PCreatorWriterJack(MetaJackXml())
        orElse
          new PCreatorWriterJack(MetaJackYaml())
        orElse
          new PCreatorWriterJack(MetaJackCsv())
        orElse
          new PCreatorWriterJack(MetaJackProperties())
        orElse
          new PCreatorWriterJack(MetaJackJavaProps())),
      new PCreatorTranslatorFake()
    )
