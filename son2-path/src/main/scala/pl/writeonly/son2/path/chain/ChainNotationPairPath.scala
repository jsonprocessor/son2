package pl.writeonly.son2.path.chain

import pl.writeonly.son2.core.converters.CreatorConverter
import pl.writeonly.son2.path.glue.{ChainNotationConfigPath, ChainNotationRWTPath}

object ChainNotationPairPath extends CreatorConverter(new ChainNotationConfigPath(), new ChainNotationRWTPath())