package pl.writeonly.son2.text.glue

import pl.writeonly.son2.core.glue.CreatorProviderOr
import pl.writeonly.son2.text.creators.PCreatorConfigText

class CreatorProviderOrText extends CreatorProviderOr(new PCreatorConfigText, new ChainNotationRWTText())
