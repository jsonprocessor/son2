package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.converters.CreatorConverter

class CreatorConverterPath
    extends CreatorConverter(new ChainNotationConfigPath(),
                             new ChainNotationRWTPath())

object CreatorConverterPath
    extends CreatorConverter(new ChainNotationConfigPath(),
                             new ChainNotationRWTPath())

object CreatorConverterPathMain
    extends CreatorConverter(new ChainNotationConfigPathMain(),
                             new ChainNotationRWTPath())
