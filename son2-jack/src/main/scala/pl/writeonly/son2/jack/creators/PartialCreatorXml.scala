package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.notation.{NotationReaderXml, NotationWriterJack}

class PartialCreatorXml(pretty: Boolean) extends PartialCreatorJack {
  def format = Formats.XML

  override def r(s: String) = new NotationReaderXml

  override def w(s: String) = new NotationWriterJack(pretty, new XmlMapper, "<!-- ", " -->")
}
