package pl.writeonly.son2.path.chain

import pl.writeonly.son2.core.chain.ChainNotationPair
import pl.writeonly.son2.core.providers.CreatorProvider
import pl.writeonly.son2.path.creators.{PartialCreatorPath, PartialCreatorSmart, PartialCreatorStrict}

class ChainNotationPairPath(pretty: Boolean) extends ChainNotationPair(
  new PartialCreatorPath
    orElse
    new PartialCreatorSmart(pretty)
    orElse
    new PartialCreatorStrict(pretty)
)

object ChainNotationPairPath extends CreatorProvider(p => new ChainNotationPairPath(p))