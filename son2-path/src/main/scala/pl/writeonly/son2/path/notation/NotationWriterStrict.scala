package pl.writeonly.son2.path.notation

import net.minidev.json.{JSONStyle, JSONValue}
import pl.writeonly.son2.core.notation.NotationWriter

class NotationWriterStrict(pretty: Boolean) extends NotationWriter(pretty) {

  override def writePretty(value: Any): String = JSONValue.toJSONString(value, JSONStyle.MAX_COMPRESS)

  override def writeRaw(value: Any): String = JSONValue.toJSONString(value, JSONStyle.NO_COMPRESS)
}
