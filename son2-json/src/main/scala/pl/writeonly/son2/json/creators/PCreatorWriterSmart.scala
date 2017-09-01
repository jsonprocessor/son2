package pl.writeonly.son2.json.creators

import pl.writeonly.son2.core.chain.PCreatorWriterSymbol
import pl.writeonly.son2.json.core.ProvidersJson
import pl.writeonly.son2.json.notation.NotationWriterSmart

class PCreatorWriterSmart extends PCreatorWriterSymbol(ProvidersJson.SMART, c => new NotationWriterSmart(c))
