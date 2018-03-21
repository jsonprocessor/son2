package pl.writeonly.son2.path.chain

import pl.writeonly.son2.apis.converters.CreatorConverter
import pl.writeonly.son2.path.glue.{
  ChainNotationConfigPathMain,
  ChainNotationRWTPath
}

class ChainNotationPairPath
    extends CreatorConverter(new ChainNotationConfigPathMain(),
                             new ChainNotationRWTPath())

object ChainNotationPairPath
    extends CreatorConverter(new ChainNotationConfigPathMain(),
                             new ChainNotationRWTPath())
