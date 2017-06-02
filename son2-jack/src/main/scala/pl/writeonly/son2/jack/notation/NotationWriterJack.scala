package pl.writeonly.son2.jack.core

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.notation.NotationWriter

class NotationWriterJack(val mapper: ObjectMapper, val pretty: Boolean = true) extends NotationWriter(pretty) {

  override def writePretty(value: Any): String = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value)

  override def writeRaw(value: Any): String = mapper.writeValueAsString(value)
}
