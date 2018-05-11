package pl.writeonly.scallions.jack.creators

import pl.writeonly.scallions.apis.chain.PCreatorWriterSymbol
import pl.writeonly.scallions.jack.core.Jack
import pl.writeonly.scallions.jack.notation.NotationWriterJack

class PCreatorWriterJack(jack: Jack)
    extends PCreatorWriterSymbol(
      jack.meta.format,
      c => new NotationWriterJack(jack, c)
    )
