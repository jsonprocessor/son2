package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.chain.PCreatorWriterSymbol
import pl.writeonly.son2.path.core.FormatsPath
import pl.writeonly.son2.path.notation.NotationWriterGson

class PCreatorWriterGson extends PCreatorWriterSymbol(FormatsPath.GSON, c => new NotationWriterGson(c))
