package pl.writeonly.son2.path.notation

import net.minidev.json.JSONValue
import pl.writeonly.son2.core.notation.NotationReader

class NotationReaderSmart(val path: String) extends NotationReader {

  def apply(content: String):Any = JSONValue.parse(content)

  def parseKeepingOrder(content: String):Any = JSONValue.parseKeepingOrder(content)

  def parseStrict(content: String):Any = JSONValue.parseStrict(content)

  def isValid(content :String): Boolean = JSONValue.isValidJson(content)

  def isValidStrict(content :String): Boolean = JSONValue.isValidJson(content)
}
