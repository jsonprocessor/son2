package pl.writeonly.son2.path.chain

import pl.writeonly.son2.core.chain.{ChainNotationPair, ProviderCreator}
import pl.writeonly.son2.path.creators.{PartialCreatorPath, PartialCreatorSmart, PartialCreatorStrict}

class ChainNotationPairPath(pretty: Boolean) extends ChainNotationPair(
  new PartialCreatorPath
    orElse
    new PartialCreatorSmart(pretty)
    orElse
    new PartialCreatorStrict(pretty)
)

object ChainNotationPairPath extends ProviderCreator(p => new ChainNotationPairPath(p)) {
}