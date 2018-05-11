package pl.writeonly.scallions.json.glue

import pl.writeonly.scallions.apis.converters.CreatorConverter

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
