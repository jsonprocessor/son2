package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.chain.ChainNotationConfig
import pl.writeonly.son2.path.core.FormatsPath
import pl.writeonly.son2.path.creators.{PCreatorConfigPath, PCreatorConfigPathQuery}

class ChainNotationConfigPath extends ChainNotationConfig(
  new PCreatorConfigPathQuery
    orElse
    new PCreatorConfigPath(FormatsPath.GSON)
    orElse
    new PCreatorConfigPath(FormatsPath.ORG)
    orElse
    new PCreatorConfigPath(FormatsPath.SMART)
    orElse
    new PCreatorConfigPath(FormatsPath.STRICT)
)
