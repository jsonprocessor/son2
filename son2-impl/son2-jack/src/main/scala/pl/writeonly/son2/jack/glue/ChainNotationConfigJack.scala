package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.core.chain.ChainNotationConfig
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.jack.creators.PCreatorConfigJack

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
      new PCreatorConfigJack(FormatsJack.JAVA_PROPS))
