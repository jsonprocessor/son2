package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.chain._
import pl.writeonly.son2.core.config.Config

class CreatorProvider(creator: ChainNotationConfig, rwt: ChainNotationRWT) {
  def apply(s: Symbol): Provider = new ChainNotationCreator(creator.get, rwt).providerOpt(s.name).get

  def apply(c: Config): Provider = new ChainNotationCreator(creator.get, rwt).provider(c)
}
