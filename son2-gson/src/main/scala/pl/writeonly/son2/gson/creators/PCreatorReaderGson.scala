package pl.writeonly.son2.gson.creators

import pl.writeonly.son2.core.chain.PCreatorReaderSymbol
import pl.writeonly.son2.gson.core.FormatsGson
import pl.writeonly.son2.gson.notation.NotationReaderGson

class PCreatorReaderGson extends PCreatorReaderSymbol(FormatsGson.GSON, _ => new NotationReaderGson())
