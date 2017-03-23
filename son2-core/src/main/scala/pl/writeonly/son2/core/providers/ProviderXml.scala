package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.Liner

//import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper

class ProviderXml extends Provider {
  override def convert(s: String): String = {
    val jsonNodeTree = new ObjectMapper().readTree(s)
//    new XmlMapper().setDefaultPrettyPrinter(new DefaultXmlPrettyPrinter).writeValueAsString(jsonNodeTree)
    new XmlMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jsonNodeTree)
  }

  override def comment(s: String) = "<!-- " + s + " -->"
}
