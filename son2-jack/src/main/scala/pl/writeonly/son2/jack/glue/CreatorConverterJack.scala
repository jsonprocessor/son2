package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.core.converters.CreatorConverter


object CreatorConverterJack extends CreatorConverter(new ChainNotationConfigJack(), new ChainNotationRWTJack())
