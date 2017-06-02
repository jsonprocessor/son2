package pl.writeonly.son2.jack.providers

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.notation.NotationWriterJackYaml

class ProviderYaml(config: Config)
  extends ProviderJack(config, new NotationWriterJackYaml(config.p)) {

}
