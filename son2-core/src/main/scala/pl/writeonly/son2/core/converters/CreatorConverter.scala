package pl.writeonly.son2.core.converters

import pl.writeonly.son2.core.chain._
import pl.writeonly.son2.core.config.Config

class CreatorConverter(creator: ChainNotationConfig, rwt: ChainNotationRWT) {
  def apply(s: Symbol): Converter = new ChainNotationCreator(creator.get, rwt)
    .providerOpt(s.name)
    .getOrElse(throw new IllegalStateException(s.name))

  def apply(c: Config): Converter = new ChainNotationCreator(creator.get, rwt)
    .provider(c)
}
