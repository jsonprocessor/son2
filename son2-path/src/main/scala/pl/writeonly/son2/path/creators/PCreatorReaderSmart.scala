package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.chain.PCreatorReaderSymbol
import pl.writeonly.son2.path.core.FormatsPath
import pl.writeonly.son2.path.notation.NotationReaderSmart

class PCreatorReaderSmart extends PCreatorReaderSymbol(FormatsPath.SMART, _ => new NotationReaderSmart())
