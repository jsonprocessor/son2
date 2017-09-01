package pl.writeonly.son2.json.glue

import pl.writeonly.son2.core.converters.CreatorConverter

object CreatorConverterJson extends CreatorConverter(new ChainNotationConfigJson(), new ChainNotationRWTJson())
