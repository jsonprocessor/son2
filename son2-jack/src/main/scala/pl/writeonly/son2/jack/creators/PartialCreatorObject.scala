package pl.writeonly.son2.jack.creators

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.notation.PartialCreatorPair
import pl.writeonly.son2.jack.core.Formats
import pl.writeonly.son2.jack.notation.{NotationReaderJack, NotationWriterJack}

class PartialCreatorObject(pretty: Boolean) extends PartialCreatorPair {
  def startsWith = Formats.OBJECT

  def r = new NotationReaderJack(new ObjectMapper)

  def w = new NotationWriterJack(pretty, new ObjectMapper, "#", "")
}
