package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import pl.writeonly.son2.core.liners.Liner

class ProviderYaml extends Provider {
  override def convert(s: String): String = {
    val jsonNodeTree = new ObjectMapper().readTree(s)
//    new YAMLMapper().writeValueAsString(jsonNodeTree)
    new YAMLMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jsonNodeTree)
  }

  override def comment(s: String) = "#" + s
}
