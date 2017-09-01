package pl.writeonly.son2.json.creators

import pl.writeonly.son2.core.chain.PCreatorWriterSymbol
import pl.writeonly.son2.json.core.ProvidersJson
import pl.writeonly.son2.json.notation.NotationWriterGson

class PCreatorWriterGson extends PCreatorWriterSymbol(ProvidersJson.GSON, c => new NotationWriterGson(c))
