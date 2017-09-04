package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.converters.CreatorConverter

object CreatorConverterPath extends CreatorConverter(new ChainNotationConfigPath(), new ChainNotationRWTPath())
