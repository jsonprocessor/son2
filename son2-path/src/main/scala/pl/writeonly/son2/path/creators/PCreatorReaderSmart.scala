package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.chain.PCreatorReaderSymbol
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.path.notation.NotationReaderSmart

class PCreatorReaderSmart extends PCreatorReaderSymbol(ProvidersPath.SMART, c => new NotationReaderSmart(c))
