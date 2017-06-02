package pl.writeonly.son2.jack.providers

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.notation.NotationWriterJackCsv

class ProviderCsv(config: Config)
  extends ProviderJack(config, new NotationWriterJackCsv(config.p)) {

}

