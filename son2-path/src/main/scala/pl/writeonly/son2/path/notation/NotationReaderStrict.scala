package pl.writeonly.son2.path.notation

import net.minidev.json.JSONValue
import pl.writeonly.son2.core.notation.NotationReader

class NotationReaderStrict() extends NotationReader {
  def apply(content: String): Any = JSONValue.parseStrict(content)

  override def isDefinedAt(content: String): Boolean = JSONValue.isValidJsonStrict(content)
}
