package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.core.core.Config

class ProviderYaml(config: Config) extends Provider(config, new YAMLMapper()) {

  override def comment(s: String) = "#" + s
}
