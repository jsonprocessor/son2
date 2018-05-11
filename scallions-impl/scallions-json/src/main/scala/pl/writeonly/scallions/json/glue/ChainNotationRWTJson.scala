package pl.writeonly.scallions.json.glue

import pl.writeonly.scallions.path.glue.ChainNotationRWTPath
import pl.writeonly.scallions.apis.chain.ChainNotationRWT

class ChainNotationRWTJson
    extends ChainNotationRWT(
      new ChainNotationRWTPath().r,
      new ChainNotationRWTPath().w,
      new ChainNotationRWTPath().t
    )
