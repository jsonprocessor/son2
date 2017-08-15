package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.jack.core.FormatsJack
import pl.writeonly.son2.jack.notation.{NotationReaderObject, NotationWriterJack}

class PartialCreatorObject(pretty: Boolean) extends PartialCreatorJack {
  def format = FormatsJack.OBJECT

  override def r(c: Config) = new NotationReaderObject

  override def w(c: Config) = new NotationWriterJack(pretty, new ObjectMapper, "#", "")
}
