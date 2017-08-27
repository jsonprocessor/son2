package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.core.chain.{ChainNotationRWT, PCreatorTranslatorFake}
import pl.writeonly.son2.jack.core._
import pl.writeonly.son2.jack.creators.{PartialCreatorReaderJack, PartialCreatorWriterJack}

class ChainNotationRWTJack extends ChainNotationRWT(
  (
    new PartialCreatorReaderJack(JackObject())
      orElse
      new PartialCreatorReaderJack(JackXml())
      orElse
      new PartialCreatorReaderJack(JackYaml())
      orElse
      new PartialCreatorReaderJack(JackCsv())
      orElse
      new PartialCreatorReaderJack(JackProperties())
      orElse
      new PartialCreatorReaderJack(JackJavaProps())
    ),
  (
    new PartialCreatorWriterJack(JackObject())
      orElse
      new PartialCreatorWriterJack(JackXml())
      orElse
      new PartialCreatorWriterJack(JackYaml())
      orElse
      new PartialCreatorWriterJack(JackCsv())
      orElse
      new PartialCreatorWriterJack(JackProperties())
      orElse
      new PartialCreatorWriterJack(JackJavaProps())
    ),
  new PCreatorTranslatorFake()
)