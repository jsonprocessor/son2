package pl.writeonly.scallions.path.chain

import pl.writeonly.scallions.apis.converters.CreatorConverter
import pl.writeonly.scallions.path.glue.{
  ChainNotationConfigPathMain,
  ChainNotationRWTPath
}

class ChainNotationPairPath
    extends CreatorConverter(
      new ChainNotationConfigPathMain(),
      new ChainNotationRWTPath()
    )

object ChainNotationPairPath
    extends CreatorConverter(
      new ChainNotationConfigPathMain(),
      new ChainNotationRWTPath()
    )
