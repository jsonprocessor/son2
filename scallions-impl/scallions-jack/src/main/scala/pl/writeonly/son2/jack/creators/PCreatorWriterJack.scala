package pl.writeonly.son2.jack.creators

import pl.writeonly.son2.apis.chain.PCreatorWriterSymbol
import pl.writeonly.son2.jack.core.Jack
import pl.writeonly.son2.jack.notation.NotationWriterJack

class PCreatorWriterJack(jack: Jack)
    extends PCreatorWriterSymbol(
      jack.meta.format,
      c => new NotationWriterJack(jack, c)
    )
