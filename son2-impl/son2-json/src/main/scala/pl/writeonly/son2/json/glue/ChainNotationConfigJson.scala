package pl.writeonly.son2.json.glue

import pl.writeonly.son2.core.chain.ChainNotationConfig
import pl.writeonly.son2.json.creators.PCreatorConfigJson
import pl.writeonly.son2.path.core.ProvidersPath

class ChainNotationConfigJson
    extends ChainNotationConfig(
      new PCreatorConfigJson(ProvidersPath.GSON)
        orElse
          new PCreatorConfigJson(ProvidersPath.JACKSON_TYPED)
        orElse
          new PCreatorConfigJson(ProvidersPath.JACKSON)
        orElse
          new PCreatorConfigJson(ProvidersPath.JETTISON)
        orElse
          new PCreatorConfigJson(ProvidersPath.ORG)
        orElse
          new PCreatorConfigJson(ProvidersPath.SMART)
        orElse
          new PCreatorConfigJson(ProvidersPath.STRICT)
        orElse
          new PCreatorConfigJson(ProvidersPath.TAPESTRY))
