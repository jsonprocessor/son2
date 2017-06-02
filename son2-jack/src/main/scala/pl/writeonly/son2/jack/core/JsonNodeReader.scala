package pl.writeonly.son2.jack.core

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.json.JsonReader

class JsonNodeReader(val mapper: ObjectMapper) extends JsonReader {
  def readTree(content: String) = mapper.readTree(content)
}
