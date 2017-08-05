package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.glue.CreatorProviderOr
import pl.writeonly.son2.path.chain.ChainNotationPairPath

class CreatorProviderOrPath extends CreatorProviderOr(new ChainNotationPairPath(true).get)
