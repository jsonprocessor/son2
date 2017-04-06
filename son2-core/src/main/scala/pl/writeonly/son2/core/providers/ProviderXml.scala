package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import pl.writeonly.son2.core.formats.Config

class ProviderXml(config: Config) extends Provider(config, new XmlMapper()) {

  override def comment(s: String) = "<!-- " + s + " -->"
}
