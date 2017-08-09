package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.jack.notation.{NotationReaderObject, NotationWriterJack}

class PartialCreatorObject(pretty: Boolean) extends PartialCreatorJack {
  def format = FormatsJack.OBJECT

  override def r(s: String) = new NotationReaderObject

  override def w(s: String) = new NotationWriterJack(pretty, new ObjectMapper, "#", "")
}
