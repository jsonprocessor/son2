package pl.writeonly.son2.core.providers

class ProviderIdentity extends Provider {
  override def convert(s: String) = s

  override def comment(s: String) = s
}
