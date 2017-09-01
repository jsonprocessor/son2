package pl.writeonly.son2.path.providers

class PCreatorConverterPair extends PartialFunction[String, ProviderPair] {
  override def isDefinedAt(s: String): Boolean = ???

  override def apply(s: String): ProviderPair = ???
}
