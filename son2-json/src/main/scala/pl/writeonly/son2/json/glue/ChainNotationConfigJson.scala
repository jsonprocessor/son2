package pl.writeonly.son2.json.glue

import pl.writeonly.son2.core.chain.ChainNotationConfig
import pl.writeonly.son2.json.creators.PCreatorConfigGson

class ChainNotationConfigJson extends ChainNotationConfig(new PCreatorConfigGson())