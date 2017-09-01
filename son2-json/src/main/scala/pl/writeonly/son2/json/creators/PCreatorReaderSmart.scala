package pl.writeonly.son2.json.creators

import pl.writeonly.son2.core.chain.PCreatorReaderSymbol
import pl.writeonly.son2.json.core.ProvidersJson
import pl.writeonly.son2.json.notation.NotationReaderSmart

class PCreatorReaderSmart extends PCreatorReaderSymbol(ProvidersJson.SMART, _ => new NotationReaderSmart())
