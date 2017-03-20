package pl.writeonly.son2.core

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter

class Son2Xml extends Son2 {
  override def convert(jsonString: String): String = {
    val jsonNodeTree = new ObjectMapper().readTree(jsonString)
//    new XmlMapper().setDefaultPrettyPrinter(new DefaultXmlPrettyPrinter).writeValueAsString(jsonNodeTree)
    new XmlMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jsonNodeTree)
  }

  override def comment(jsonString: String) = "<!-- " + jsonString + " -->"
}
