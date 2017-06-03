package pl.writeonly.son2.jack.notation

import com.fasterxml.jackson.dataformat.xml.XmlMapper

class NotationWriterJackXml(val pretty: Boolean)
  extends NotationWriterJack(pretty, new XmlMapper(), "<!-- ", " -->") {
}
