package pl.writeonly.son2.json.glue

import pl.writeonly.son2.core.chain.ChainNotationConfig
import pl.writeonly.son2.json.core.ProvidersJson
import pl.writeonly.son2.json.creators.PCreatorConfigJson

class ChainNotationConfigJson extends ChainNotationConfig(
  new PCreatorConfigJson(ProvidersJson.JACKSON)
    orElse
    new PCreatorConfigJson(ProvidersJson.SMART)
    orElse
    new PCreatorConfigJson(ProvidersJson.GSON)
)