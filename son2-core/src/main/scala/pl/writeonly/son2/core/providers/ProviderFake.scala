package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.config.Config

class ProviderFake extends Provider(new Config()) {
  override def convert(s: String):String = s
  override def comment(s: String):String = s
}
