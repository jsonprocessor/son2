package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.core.providers.CreatorProvider


object CreatorProviderJack extends CreatorProvider(new ChainNotationConfigJack(), new ChainNotationRWTJack())
