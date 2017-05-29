package pl.writeonly.son2.jack.providers

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.jack.core.Config

class ProviderObject(config: Config) extends ProviderJack(config, new ObjectMapper()) {

  override def comment(s: String) = "#" + s
}
