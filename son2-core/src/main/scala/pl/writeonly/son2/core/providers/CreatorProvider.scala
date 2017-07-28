package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.chain.{ChainNotationCreator, ChainNotationPair}
import pl.writeonly.son2.core.config.Config

class CreatorProvider(creator: Boolean => ChainNotationPair) {
  def apply(s: Symbol): Provider = new ChainNotationCreator(creator(true).get).lift(s.name).get

  def apply(c: Config): Provider = new ChainNotationCreator(creator(false).get).provider(c)
}
