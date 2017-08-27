package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.chain.ChainNotationConfig
import pl.writeonly.son2.path.core.Formats
import pl.writeonly.son2.path.creators.{PCreatorConfigPath, PCreatorConfigPathQuery}

class ChainNotationConfigPath extends ChainNotationConfig(
  new PCreatorConfigPathQuery
    orElse
    new PCreatorConfigPath(Formats.SMART)
    orElse
    new PCreatorConfigPath(Formats.STRICT)
)
