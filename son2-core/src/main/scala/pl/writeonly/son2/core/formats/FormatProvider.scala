package pl.writeonly.son2.core.formats

import pl.writeonly.son2.core.providers._

class FormatProvider extends Format[Provider] {
  override def apply(): Provider = new ProviderObject

  override def yaml(): Provider = new ProviderYaml

  override def xml(): Provider = new ProviderXml

  override def csv(): Provider = new ProviderCsv

  override def javaprops(): Provider = new ProviderJavaProps
}
