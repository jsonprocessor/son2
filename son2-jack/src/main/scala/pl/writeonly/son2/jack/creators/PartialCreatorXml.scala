package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.jack.notation.{NotationReaderXml, NotationWriterJack}

class PartialCreatorXml(pretty: Boolean) extends PartialCreatorJack {
  def format = FormatsJack.XML

  override def r(c: Config) = new NotationReaderXml

  override def w(c: Config) = new NotationWriterJack(c.write, pretty, new XmlMapper, "<!-- ", " -->")
}
