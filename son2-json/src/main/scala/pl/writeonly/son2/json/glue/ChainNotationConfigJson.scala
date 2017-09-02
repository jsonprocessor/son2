package pl.writeonly.son2.json.glue

import pl.writeonly.son2.core.chain.ChainNotationConfig
import pl.writeonly.son2.json.core.ProvidersJson
import pl.writeonly.son2.json.creators.PCreatorConfigJson
import pl.writeonly.son2.path.core.FormatsPath

class ChainNotationConfigJson extends ChainNotationConfig(
  new PCreatorConfigJson(FormatsPath.SMART)
    orElse
    new PCreatorConfigJson(FormatsPath.STRICT)
    orElse
    new PCreatorConfigJson(FormatsPath.GSON)
    orElse
    new PCreatorConfigJson(ProvidersJson.OBJECT)
)