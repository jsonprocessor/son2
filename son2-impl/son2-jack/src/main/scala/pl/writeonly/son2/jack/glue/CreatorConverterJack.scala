package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.apis.converters.CreatorConverter

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
