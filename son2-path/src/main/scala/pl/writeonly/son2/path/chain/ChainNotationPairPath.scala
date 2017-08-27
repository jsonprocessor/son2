package pl.writeonly.son2.path.chain

import pl.writeonly.son2.core.providers.CreatorProvider
import pl.writeonly.son2.path.glue.{ChainNotationConfigPath, ChainNotationRWTPath}

object ChainNotationPairPath extends CreatorProvider(new ChainNotationConfigPath(), new ChainNotationRWTPath())