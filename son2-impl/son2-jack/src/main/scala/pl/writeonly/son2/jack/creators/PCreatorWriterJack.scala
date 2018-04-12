package pl.writeonly.son2.jack.creators

import pl.writeonly.son2.apis.chain.PCreatorWriterSymbol
import pl.writeonly.son2.jack.core.MetaJack
import pl.writeonly.son2.jack.notation.NotationWriterJack

class PCreatorWriterJack(jack: MetaJack)
    extends PCreatorWriterSymbol(
      jack.format,
      c => new NotationWriterJack(c, jack)
    )
