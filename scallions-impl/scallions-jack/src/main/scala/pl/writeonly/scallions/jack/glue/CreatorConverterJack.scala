package pl.writeonly.scallions.jack.glue

import pl.writeonly.scallions.apis.converters.CreatorConverter

class CreatorConverterJack
    extends CreatorConverter(
      new ChainNotationConfigJack(),
      new ChainNotationRWTJack()
    )

object CreatorConverterJack
    extends CreatorConverter(
      new ChainNotationConfigJack(),
      new ChainNotationRWTJack()
    )
