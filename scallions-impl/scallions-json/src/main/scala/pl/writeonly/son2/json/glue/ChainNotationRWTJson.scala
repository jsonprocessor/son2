package pl.writeonly.son2.json.glue

import pl.writeonly.son2.apis.chain.ChainNotationRWT
import pl.writeonly.son2.path.glue.ChainNotationRWTPath

class ChainNotationRWTJson
    extends ChainNotationRWT(
      new ChainNotationRWTPath().r,
      new ChainNotationRWTPath().w,
      new ChainNotationRWTPath().t
    )
