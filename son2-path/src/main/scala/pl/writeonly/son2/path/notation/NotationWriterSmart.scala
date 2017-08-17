package pl.writeonly.son2.path.notation

import net.minidev.json.{JSONStyle, JSONValue}
import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.notation.NotationWriter

class NotationWriterSmart(c:WConfig, pretty: Boolean) extends NotationWriter(c, pretty) {

  override def writePretty(value: Any): String = JSONValue.toJSONString(value, JSONStyle.MAX_COMPRESS)

  override def writeRaw(value: Any): String = JSONValue.toJSONString(value, JSONStyle.NO_COMPRESS)
}
