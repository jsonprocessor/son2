package pl.writeonly.son2.jack.formats.creators

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.notation._
import pl.writeonly.son2.jack.providers._

class CreatorFormatProvider(config: Config) extends CreatorFormat[ProviderJack] {

  override def on: ProviderJack = new ProviderJack(config, new NotationWriterJackObject(config.p))

  override def yaml: ProviderJack = new ProviderJack(config, new NotationWriterJackYaml(config.p))

  override def xml: ProviderJack = new ProviderJack(config, new NotationWriterJackXml(config.p))

  override def csv: ProviderJack = new ProviderJack(config, new NotationWriterJackCsv(config.p))

  override def javaprops: ProviderJack = new ProviderJack(config, new NotationWriterJackJavaProps(config.p))

}

