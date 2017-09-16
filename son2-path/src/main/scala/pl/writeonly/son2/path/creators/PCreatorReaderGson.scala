package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.chain.PCreatorReaderSymbol
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.path.notation.NotationReaderGson

class PCreatorReaderGson extends PCreatorReaderSymbol(ProvidersPath.GSON, c => new NotationReaderGson(c))
