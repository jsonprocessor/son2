package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.glue.CreatorProviderOr

class CreatorProviderOrPath extends CreatorProviderOr(new ChainNotationConfigPath().get, new ChainNotationRWTPath())
