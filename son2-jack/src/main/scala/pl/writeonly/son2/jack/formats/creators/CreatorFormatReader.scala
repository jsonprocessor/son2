package pl.writeonly.son2.jack.formats.creators

import pl.writeonly.son2.jack.notation._

class CreatorFormatReader extends CreatorFormat[NotationReaderJack] {

  override def on: NotationReaderJack = new NotationReaderObject

  override def yaml: NotationReaderJack = new NotationReaderYaml

  override def xml: NotationReaderJack = new NotationReaderXml

  override def csv: NotationReaderJack = new NotationReaderCsv

  override def javaprops: NotationReaderJack = new NotationReaderJavaProps
}

