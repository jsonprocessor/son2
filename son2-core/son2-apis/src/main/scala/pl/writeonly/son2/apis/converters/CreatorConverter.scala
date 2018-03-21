package pl.writeonly.son2.apis.converters

import pl.writeonly.son2.apis.chain._
import pl.writeonly.son2.apis.config.{Format, Provider, RWTConfig}

class CreatorConverter(creator: ChainNotationConfig, rwt: ChainNotationRWT) {
  def apply(s: Provider): Converter =
    new ChainNotationCreator(creator.get, rwt)
      .providerOpt(s.name)
      .getOrElse(throw new IllegalStateException(s.name))

  def apply(s: Format): Converter =
    new ChainNotationCreator(creator.get, rwt)
      .providerOpt(s.name)
      .getOrElse(throw new IllegalStateException(s.name))

  def apply(c: RWTConfig): Converter =
    new ChainNotationCreator(creator.get, rwt)
      .provider(c)
}
