package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.core.Config

class ProviderImpl extends Provider(Config(), null) {
  override def convert(s: String) = s

}
