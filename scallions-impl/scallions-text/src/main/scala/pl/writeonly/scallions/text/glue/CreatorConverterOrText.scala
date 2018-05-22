package pl.writeonly.scallions.text.glue

import pl.writeonly.scallions.funs.glue.CreatorConverterOr
import pl.writeonly.scallions.text.creators.PCreatorConfigText

class CreatorConverterOrText
    extends CreatorConverterOr(
      new PCreatorConfigText,
      new ChainNotationRWTText()
    )
