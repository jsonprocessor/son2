package pl.writeonly.son2.text.glue

import pl.writeonly.son2.core.glue.CreatorProviderOr
import pl.writeonly.son2.text.chain.ChainNotationPairText

class CreatorProviderOrText extends CreatorProviderOr(new ChainNotationPairText().get)
