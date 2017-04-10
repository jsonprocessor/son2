package pl.writeonly.son2.core.formats

import pl.writeonly.son2.core.core.Config
import pl.writeonly.son2.core.providers._

class FormatProvider(config: Config) extends Format[Provider] {

  override def on(): Provider = new ProviderObject(config)

  override def yaml(): Provider = new ProviderYaml(config)

  override def xml(): Provider = new ProviderXml(config)

  override def csv(): Provider = new ProviderCsv(config)

  override def javaprops(): Provider = new ProviderJavaProps(config)

  def apply(): Option[Provider] = apply(config.o)
}

object FormatProvider {
  def apply(o: String): Provider = apply(Config(o = o))

  def apply(config: Config): Provider = opt(config).get

  def opt(config: Config): Option[Provider] = new FormatProvider(config).apply()
}
