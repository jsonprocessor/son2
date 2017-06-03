package pl.writeonly.son2.jack.formats.creators

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.formats.matchers.MatcherFormatMapper
import pl.writeonly.son2.jack.notation.{NotationWriterJack, _}
import pl.writeonly.son2.jack.providers.{ProviderJack, _}

class CreatorFormatProvider(config: Config) extends CreatorFormat[ProviderJack] {

  override def on: ProviderJack = providerJack(w.on)

  override def yaml: ProviderJack = providerJack(w.yaml)

  override def xml: ProviderJack = providerJack(w.xml)

  override def csv: ProviderJack = providerJack(w.csv)

  override def javaprops: ProviderJack = providerJack(w.javaprops)

  def in = new NotationReaderJack(MatcherFormatMapper(config))

  def w = new CreatorFormatWriter(config)

  def providerJack(out : NotationWriterJack) = new ProviderJack(in, out)

}

