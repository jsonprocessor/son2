package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.notation.{NotationReaderXml, NotationWriterJack}

class PartialCreatorXml(pretty: Boolean) extends PartialCreatorJack {
  def format = Formats.XML

  def r = new NotationReaderXml

  def w = new NotationWriterJack(pretty, new XmlMapper, "<!-- ", " -->")
}
