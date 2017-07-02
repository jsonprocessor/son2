package pl.writeonly.son2.path.notation

import net.minidev.json.JSONValue
import pl.writeonly.son2.core.notation.NotationReader

class NotationReaderSmart() extends NotationReader {
  def apply(content: String): Any = JSONValue.parse(content)

  override def isDefinedAt(content: String): Boolean = JSONValue.isValidJson(content)
}
