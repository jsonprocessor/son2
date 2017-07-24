package pl.writeonly.son2.core.chain

import pl.writeonly.son2.core.notation.Config
import pl.writeonly.son2.core.providers.Provider

class ProviderCreator(creator: Boolean => ChainNotationPair) {
  def apply(s: Symbol): Provider = new ChainNotationCreator(creator(true).get).lift(s.name).get

  def apply(c: Config): Provider = new ChainNotationCreator(creator(false).get).provider(c)
}
