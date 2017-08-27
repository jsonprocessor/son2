package pl.writeonly.son2.gson

import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.notation.NotationWriter

class NotationWriterGson(c: WConfig, jack: Jack)
  extends NotationWriter(c) {

  override def writePretty(value: Any): String = jack.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value)

  override def writeRaw(value: Any): String = jack.mapper.writeValueAsString(value)

  override def comment(s: String) = jack.s1 + s + jack.s2

}
