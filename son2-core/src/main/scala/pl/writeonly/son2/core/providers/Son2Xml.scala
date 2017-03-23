package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.Liner

class Son2Xml extends Liner {
  override def convert(jsonString: String): String = {
    val jsonNodeTree = new ObjectMapper().readTree(jsonString)
//    new XmlMapper().setDefaultPrettyPrinter(new DefaultXmlPrettyPrinter).writeValueAsString(jsonNodeTree)
    new XmlMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jsonNodeTree)
  }

  override def comment(jsonString: String) = "<!-- " + jsonString + " -->"
}
