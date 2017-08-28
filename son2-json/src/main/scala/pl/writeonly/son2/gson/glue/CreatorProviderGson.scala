package pl.writeonly.son2.gson.glue

import pl.writeonly.son2.core.providers.CreatorProvider


object CreatorProviderGson extends CreatorProvider(new ChainNotationConfigJack(), new ChainNotationRWTJack())
