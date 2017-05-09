package pl.writeonly.son2.jack.providers

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import pl.writeonly.son2.jack.core.Config

class ProviderXml(config: Config) extends Provider(config, new XmlMapper()) {

  override def comment(s: String) = "<!-- " + s + " -->"
}
