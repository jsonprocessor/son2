package pl.writeonly.son2.core.providers

class ProviderFake extends Provider(null, null) {
  override def convert(s: String) = s
}
