package pl.writeonly.scallions.path.glue

import pl.writeonly.scallions.funs.glue.CreatorConverterOr

class CreatorConverterOrPath
    extends CreatorConverterOr(
      new ChainNotationConfigPath().get,
      new ChainNotationRWTPath()
    )

class CreatorConverterOrPathMain
    extends CreatorConverterOr(
      new ChainNotationConfigPathMain().get,
      new ChainNotationRWTPath()
    )
