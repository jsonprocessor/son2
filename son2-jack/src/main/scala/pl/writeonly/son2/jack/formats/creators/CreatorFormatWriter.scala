package pl.writeonly.son2.jack.formats.creators

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.notation._

class CreatorFormatWriter(config: Config) extends CreatorFormat[NotationWriterJack] {

  override def on: NotationWriterJack = new NotationWriterJackObject(pretty)

  override def yaml: NotationWriterJack = new NotationWriterJackYaml(pretty)

  override def xml: NotationWriterJack = new NotationWriterJackXml(pretty)

  override def csv: NotationWriterJack = new NotationWriterJackCsv(pretty)

  override def javaprops: NotationWriterJack = new NotationWriterJackJavaProps(pretty)

  def pretty = config.p

}

