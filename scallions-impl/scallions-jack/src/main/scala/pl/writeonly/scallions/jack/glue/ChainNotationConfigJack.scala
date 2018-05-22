package pl.writeonly.scallions.jack.glue

import pl.writeonly.scallions.apis.chain.ChainNotationConfig
import pl.writeonly.scallions.jack.core.FormatsJack
import pl.writeonly.scallions.jack.creators.PCreatorConfigJack

class ChainNotationConfigJack
    extends ChainNotationConfig(
      new PCreatorConfigJack(FormatsJack.OBJECT)
        orElse
          new PCreatorConfigJack(FormatsJack.XML)
        orElse
          new PCreatorConfigJack(FormatsJack.YAML)
        orElse
          new PCreatorConfigJack(FormatsJack.CSV)
        orElse
          new PCreatorConfigJack(FormatsJack.PROPERTIES)
        orElse
          new PCreatorConfigJack(FormatsJack.JAVA_PROPS)
    )
