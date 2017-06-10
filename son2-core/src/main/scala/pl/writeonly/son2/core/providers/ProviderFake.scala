package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.glue.Config

class ProviderFake extends Provider(new Config(), null, null) {
  override def convert(s: String) = s
}
