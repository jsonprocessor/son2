package pl.writeonly.son2.jack.creators

import pl.writeonly.son2.apis.chain.PCreatorReaderSymbol
import pl.writeonly.son2.jack.core.MetaJack
import pl.writeonly.son2.jack.notation.NotationReaderJack

class PCreatorReaderJack(jack: MetaJack)
    extends PCreatorReaderSymbol(jack.format, _ => new NotationReaderJack(jack))
