package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.liners.Liner

//import com.fasterxml.jackson.dataformat.xml.XmlMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper

class ProviderXml(in:ObjectMapper) extends Provider(in, new XmlMapper()) {

  override def comment(s: String) = "<!-- " + s + " -->"
}
