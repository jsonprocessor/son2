package pl.writeonly.son2.json.creators

import pl.writeonly.son2.core.chain.PCreatorReaderSymbol
import pl.writeonly.son2.json.core.FormatsGson
import pl.writeonly.son2.json.notation.NotationReaderGson

class PCreatorReaderGson extends PCreatorReaderSymbol(FormatsGson.GSON, _ => new NotationReaderGson())
