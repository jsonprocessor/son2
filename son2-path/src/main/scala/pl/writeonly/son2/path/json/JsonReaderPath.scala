package pl.writeonly.son2.path.json

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.json.JsonReader

class JsonReaderPath(val mapper: ObjectMapper) extends JsonReader {
  def readTree(content: String) = mapper.readTree(content)
}
