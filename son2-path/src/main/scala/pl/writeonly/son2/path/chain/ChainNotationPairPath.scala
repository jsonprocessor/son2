package pl.writeonly.son2.path.chain

import pl.writeonly.son2.core.chain.ChainNotationPair
import pl.writeonly.son2.path.creators.{PartialCreatorPath, PartialCreatorSmart, PartialCreatorStrict}

class ChainNotationPairPath(pretty: Boolean) extends ChainNotationPair(
  new PartialCreatorPath
  orElse
  new PartialCreatorSmart(pretty)
  orElse
  new PartialCreatorStrict(pretty)
)
