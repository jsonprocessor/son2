package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.core.Config

class ProviderObject(config: Config) extends Provider(config, new ObjectMapper()) {

  override def comment(s: String) = "#" + s
}
