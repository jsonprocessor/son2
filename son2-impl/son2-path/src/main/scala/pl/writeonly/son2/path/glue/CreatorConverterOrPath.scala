package pl.writeonly.son2.path.glue

import pl.writeonly.son2.funs.glue.CreatorConverterOr

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
