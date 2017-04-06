package pl.writeonly.son2.core.formats

import pl.writeonly.son2.core.providers._

class FormatProvider(config : Config) extends Format[Provider] {

  override def on(): Provider = new ProviderObject(FormatMapper(config))

  override def yaml(): Provider = new ProviderYaml(FormatMapper(config))

  override def xml(): Provider = new ProviderXml(FormatMapper(config))

  override def csv(): Provider = new ProviderCsv(FormatMapper(config))

  override def javaprops(): Provider = new ProviderJavaProps(FormatMapper(config))

  def apply():Option[Provider] = apply(config.o)
}

object FormatProvider {
  def apply(o:String):Provider = apply(Config(o=o))

  def apply(config:Config):Provider = new FormatProvider(config).apply().get
}
