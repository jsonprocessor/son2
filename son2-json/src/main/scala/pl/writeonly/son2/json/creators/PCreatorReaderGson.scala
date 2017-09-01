package pl.writeonly.son2.json.creators

import pl.writeonly.son2.core.chain.PCreatorReaderSymbol
import pl.writeonly.son2.json.core.ProvidersJson
import pl.writeonly.son2.json.notation.NotationReaderGson

class PCreatorReaderGson extends PCreatorReaderSymbol(ProvidersJson.GSON, _ => new NotationReaderGson())
