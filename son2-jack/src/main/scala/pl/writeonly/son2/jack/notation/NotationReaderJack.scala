package pl.writeonly.son2.jack.core

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.notation.NotationReader

class JsonNodeReader(val mapper: ObjectMapper) extends NotationReader {
  def readTree(content: String) = mapper.readTree(content)
}
