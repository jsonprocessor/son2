package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.chain.PCreatorWriterSymbol
import pl.writeonly.son2.path.core.FormatsPath
import pl.writeonly.son2.path.notation.NotationWriterSmart

class PCreatorWriterSmart extends PCreatorWriterSymbol(FormatsPath.SMART, c => new NotationWriterSmart(c))
