package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.databind.ObjectMapper

class ProviderObject extends Provider {
  override def convert(s: String): String = {
    val jsonNodeTree = new ObjectMapper().readTree(s)
//    new ObjectMapper().setDefaultPrettyPrinter(new DefaultPrettyPrinter).writeValueAsString(jsonNodeTree)
    new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jsonNodeTree)
  }

  override def comment(s: String) = "#" + s
}
