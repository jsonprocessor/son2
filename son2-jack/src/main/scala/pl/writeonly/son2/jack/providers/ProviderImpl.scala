package pl.writeonly.son2.jack.providers

import pl.writeonly.son2.jack.core.Config

class ProviderImpl extends Provider(Config(), null) {
  override def convert(s: String) = s
}
