package pl.writeonly.son2.apis.converters

import pl.writeonly.son2.apis.chain._
import pl.writeonly.son2.apis.config.{
  Format,
  IllegalSymbolException,
  ProviderType,
  RWTConfig
}

class CreatorConverter(creator: ChainNotationConfig, rwt: ChainNotationRWT) {
  def apply(s: ProviderType): Converter =
    new ChainNotationCreator(creator.get, rwt)
      .providerOpt(s.name)
      .getOrElse(throw IllegalSymbolException(s))

  def apply(s: Format): Converter =
    new ChainNotationCreator(creator.get, rwt)
      .providerOpt(s.name)
      .getOrElse(throw IllegalSymbolException(s))

  def apply(c: RWTConfig): Converter =
    new ChainNotationCreator(creator.get, rwt)
      .provider(c)
}
