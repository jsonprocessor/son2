package pl.writeonly.scallions.json.glue

import pl.writeonly.scallions.json.creators.PCreatorConfigJson
import pl.writeonly.scallions.path.core.ProvidersPath
import pl.writeonly.scallions.apis.chain.ChainNotationConfig

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
          new PCreatorConfigJson(ProvidersPath.TAPESTRY)
    )
