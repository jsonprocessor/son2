package pl.writeonly.son2.jack.chain

import pl.writeonly.son2.core.providers.CreatorProvider
import pl.writeonly.son2.jack.glue.{ChainNotationConfigJack, ChainNotationRWTJack}


object ChainNotationPairJack extends CreatorProvider(new ChainNotationConfigJack(), new ChainNotationRWTJack())
