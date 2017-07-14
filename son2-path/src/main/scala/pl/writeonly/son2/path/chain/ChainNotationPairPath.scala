package pl.writeonly.son2.path.chain

import pl.writeonly.son2.core.chain.{ChainNotationCreator, ChainNotationPair}
import pl.writeonly.son2.core.notation.Config
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.path.creators.{PartialCreatorPath, PartialCreatorSmart, PartialCreatorStrict}

class ChainNotationPairPath(pretty: Boolean) extends ChainNotationPair(
  new PartialCreatorPath
    orElse
    new PartialCreatorSmart(pretty)
    orElse
    new PartialCreatorStrict(pretty)
)

object ChainNotationPairPath {
  def apply(s : Symbol) : Provider = new ChainNotationCreator(new ChainNotationPairPath(true).get).chain(s.name).get

  def apply(c :Config) : Provider = new ChainNotationCreator(new ChainNotationPairPath(false).get).provider(c)
}