package pl.writeonly.son2.path.notation

import net.minidev.json.JSONValue
import pl.writeonly.son2.core.notation.NotationReader

class NotationReaderSmart() extends NotationReader {
  def apply(content: String):Any = JSONValue.parse(content)
  def isValid(content :String): Boolean = JSONValue.isValidJson(content)
}
