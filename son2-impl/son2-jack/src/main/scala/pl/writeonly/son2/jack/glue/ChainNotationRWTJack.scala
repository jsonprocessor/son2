package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.core.chain.{ChainNotationRWT, PCreatorTranslatorFake}
import pl.writeonly.son2.jack.core._
import pl.writeonly.son2.jack.creators.{PCreatorReaderJack, PCreatorWriterJack}

class ChainNotationRWTJack
    extends ChainNotationRWT(
      (
        new PCreatorReaderJack(JackObject())
          orElse
            new PCreatorReaderJack(JackXml())
          orElse
            new PCreatorReaderJack(JackYaml())
          orElse
            new PCreatorReaderJack(JackCsv())
          orElse
            new PCreatorReaderJack(JackProperties())
          orElse
            new PCreatorReaderJack(JackJavaProps())
      ),
      (
        new PCreatorWriterJack(JackObject())
          orElse
            new PCreatorWriterJack(JackXml())
          orElse
            new PCreatorWriterJack(JackYaml())
          orElse
            new PCreatorWriterJack(JackCsv())
          orElse
            new PCreatorWriterJack(JackProperties())
          orElse
            new PCreatorWriterJack(JackJavaProps())
      ),
      new PCreatorTranslatorFake()
    )
