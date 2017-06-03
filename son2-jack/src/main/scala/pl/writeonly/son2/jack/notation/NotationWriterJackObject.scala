package pl.writeonly.son2.jack.notation

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.notation.NotationWriter

class NotationWriterJackObject(val pretty: Boolean)
  extends NotationWriterJack(pretty, new ObjectMapper(), "#", "") {
}
