package pl.writeonly.son2.jack.notation

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.notation.NotationWriter

class NotationWriterJack(  pretty: Boolean, mapper: ObjectMapper) extends NotationWriter(pretty) {

  def this(mapper: ObjectMapper, pretty: Boolean) = this(pretty, mapper)

  override def writePretty(value: Any): String = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value)

  override def writeRaw(value: Any): String = mapper.writeValueAsString(value)

}
