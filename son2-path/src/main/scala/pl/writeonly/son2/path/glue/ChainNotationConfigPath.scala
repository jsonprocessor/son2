package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.chain.ChainNotationConfig
import pl.writeonly.son2.path.core.FormatsPath
import pl.writeonly.son2.path.creators.{PCreatorConfigPath, PCreatorConfigPathMain}

class ChainNotationConfigPath extends ChainNotationConfig(
  new PCreatorConfigPath(FormatsPath.GSON)
    orElse
    new PCreatorConfigPath(FormatsPath.JACKSON)
    orElse
    new PCreatorConfigPath(FormatsPath.JACKSON_NODE)
    orElse
    new PCreatorConfigPath(FormatsPath.JETTISON)
    orElse
    new PCreatorConfigPath(FormatsPath.ORG)
    orElse
    new PCreatorConfigPath(FormatsPath.SMART)
    orElse
    new PCreatorConfigPath(FormatsPath.STRICT)
    orElse
    new PCreatorConfigPath(FormatsPath.TAPESTRY)
)

class ChainNotationConfigPathMain extends ChainNotationConfig(
  new PCreatorConfigPathMain
    orElse
    new ChainNotationConfigPath().get
)
