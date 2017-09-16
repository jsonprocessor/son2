package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.chain.PCreatorWriterSymbol
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.path.notation.NotationWriterSmart

class PCreatorWriterSmart extends PCreatorWriterSymbol(ProvidersPath.SMART, c => new NotationWriterSmart(c))
