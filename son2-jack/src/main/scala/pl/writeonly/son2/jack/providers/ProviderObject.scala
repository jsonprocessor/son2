package pl.writeonly.son2.jack.providers

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.notation.NotationWriterJackObject

class ProviderObject(config: Config)
  extends ProviderJack(config, new NotationWriterJackObject(config.p)) {

  override def comment(s: String) = "#" + s
}
