package pl.writeonly.son2.jack.notation

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.notation.NotationReader

class NotationReaderJack(val mapper: ObjectMapper) extends NotationReader {
  def apply(content: String) = mapper.readTree(content)
}
