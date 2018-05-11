package pl.writeonly.scallions.text.glue

import pl.writeonly.scallions.text.creators.PCreatorConfigText
import pl.writeonly.scallions.funs.glue.CreatorConverterOr

class CreatorConverterOrText
    extends CreatorConverterOr(
      new PCreatorConfigText,
      new ChainNotationRWTText()
    )
