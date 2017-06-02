package pl.writeonly.son2.jack.providers

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.notation.NotationWriterJackXml

class ProviderXml(config: Config)
  extends ProviderJack(config, new NotationWriterJackXml(config.p)) {

}
