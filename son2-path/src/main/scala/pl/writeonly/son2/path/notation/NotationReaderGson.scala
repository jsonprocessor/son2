package pl.writeonly.son2.path.notation

import com.google.gson.{JsonElement, JsonParser}
import pl.writeonly.son2.core.notation.NotationReader

class NotationReaderGson() extends NotationReader {
  def apply(content: String): JsonElement = new JsonParser().parse(content)
}
