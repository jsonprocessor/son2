package pl.writeonly.son2.json.glue

import pl.writeonly.son2.apis.converters.CreatorConverter

class CreatorConverterJson
    extends CreatorConverter(
      new ChainNotationConfigJson(),
      new ChainNotationRWTJson()
    )

object CreatorConverterJson
    extends CreatorConverter(
      new ChainNotationConfigJson(),
      new ChainNotationRWTJson()
    )
