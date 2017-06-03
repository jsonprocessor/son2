package pl.writeonly.son2.jack.formats.creators

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.formats.matchers.MatcherFormatMapper
import pl.writeonly.son2.jack.notation._
import pl.writeonly.son2.jack.providers._

class CreatorFormatProvider(config: Config) extends CreatorFormat[ProviderJack] {

  override def on: ProviderJack = new ProviderJack(in, new NotationWriterJackObject(config.p))

  override def yaml: ProviderJack = new ProviderJack(in, new NotationWriterJackYaml(config.p))

  override def xml: ProviderJack = new ProviderJack(in, new NotationWriterJackXml(config.p))

  override def csv: ProviderJack = new ProviderJack(in, new NotationWriterJackCsv(config.p))

  override def javaprops: ProviderJack = new ProviderJack(in, new NotationWriterJackJavaProps(config.p))

  def in = new NotationReaderJack(MatcherFormatMapper(config))

}

