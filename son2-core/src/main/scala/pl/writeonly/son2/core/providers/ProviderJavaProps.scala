package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.Liner

//import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper

class ProviderJavaProps extends Provider {
  override def convert(s: String): String = {
    val jsonNodeTree = new ObjectMapper().readTree(s)
//    new JavaPropsMapper().setDefaultPrettyPrinter(new DefaultPrettyPrinter).writeValueAsString(jsonNodeTree)
    new JavaPropsMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jsonNodeTree)
  }

  override def comment(s: String) = "#" + s
}
