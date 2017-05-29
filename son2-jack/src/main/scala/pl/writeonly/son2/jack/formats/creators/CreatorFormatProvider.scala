package pl.writeonly.son2.jack.formats.creators

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.providers._

class CreatorFormatProvider(config: Config) extends CreatorFormat[ProviderJack] {

  override def on: ProviderJack = new ProviderObject(config)

  override def yaml: ProviderJack = new ProviderYaml(config)

  override def xml: ProviderJack = new ProviderXml(config)

  override def csv: ProviderJack = new ProviderCsv(config)

  override def javaprops: ProviderJack = new ProviderJavaProps(config)

}

