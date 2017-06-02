package pl.writeonly.son2.jack.providers

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.notation.NotationWriterJackJavaProps

class ProviderJavaProps(config: Config)
  extends ProviderJack(config, new NotationWriterJackJavaProps(config.p)) {

}
