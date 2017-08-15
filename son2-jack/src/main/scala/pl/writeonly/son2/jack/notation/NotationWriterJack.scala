package pl.writeonly.son2.jack.notation

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.notation.NotationWriter

class NotationWriterJack(pretty: Boolean, mapper: ObjectMapper, s1: String, s2: String) extends NotationWriter(pretty) {

  override def writePretty(value: Any): String = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value)

  override def writeRaw(value: Any): String = mapper.writeValueAsString(value)

  override def comment(s: String) = s1 + s + s2

}
