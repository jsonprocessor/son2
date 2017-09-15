package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.chain.PCreatorReaderSymbol
import pl.writeonly.son2.path.core.FormatsPath
import pl.writeonly.son2.path.notation.NotationReaderGson

class PCreatorReaderGson extends PCreatorReaderSymbol(FormatsPath.GSON, c => new NotationReaderGson(c))
