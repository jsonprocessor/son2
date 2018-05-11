package pl.writeonly.scallions.path.glue

import pl.writeonly.scallions.apis.converters.CreatorConverter

class CreatorConverterPath
    extends CreatorConverter(
      new ChainNotationConfigPath(),
      new ChainNotationRWTPath()
    )

object CreatorConverterPath
    extends CreatorConverter(
      new ChainNotationConfigPath(),
      new ChainNotationRWTPath()
    )

object CreatorConverterPathMain
    extends CreatorConverter(
      new ChainNotationConfigPathMain(),
      new ChainNotationRWTPath()
    )
