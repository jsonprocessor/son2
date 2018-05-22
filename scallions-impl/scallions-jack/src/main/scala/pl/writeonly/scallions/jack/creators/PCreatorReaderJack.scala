package pl.writeonly.scallions.jack.creators

import pl.writeonly.scallions.apis.chain.PCreatorReaderSymbol
import pl.writeonly.scallions.jack.core.Jack
import pl.writeonly.scallions.jack.notation.NotationReaderJack

class PCreatorReaderJack(jack: Jack)
    extends PCreatorReaderSymbol(
      jack.meta.format,
      _ => new NotationReaderJack(jack)
    )
