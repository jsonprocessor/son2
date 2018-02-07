package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.chain.ChainNotationConfig
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.path.creators.{
  PCreatorConfigPath,
  PCreatorConfigPathMain
}

class ChainNotationConfigPath
    extends ChainNotationConfig(
      new PCreatorConfigPath(ProvidersPath.GSON)
        orElse
          new PCreatorConfigPath(ProvidersPath.JACKSON)
        orElse
          new PCreatorConfigPath(ProvidersPath.JACKSON_TYPED)
        orElse
          new PCreatorConfigPath(ProvidersPath.JETTISON)
        orElse
          new PCreatorConfigPath(ProvidersPath.ORG)
        orElse
          new PCreatorConfigPath(ProvidersPath.SMART)
        orElse
          new PCreatorConfigPath(ProvidersPath.STRICT)
        orElse
          new PCreatorConfigPath(ProvidersPath.TAPESTRY))

class ChainNotationConfigPathMain
    extends ChainNotationConfig(
      new PCreatorConfigPathMain
        orElse
          new ChainNotationConfigPath().get)
