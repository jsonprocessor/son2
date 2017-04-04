package pl.writeonly.son2.impl.core.providers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.impl.core.liners.Liner

class ProviderYaml() extends Provider(new YAMLMapper()) {

  override def comment(s: String) = "#" + s
}