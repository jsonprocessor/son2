package pl.writeonly.son2.core.notation

import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.core.DString

class NotationTranslator(c: WConfig, t: DString)
    extends NotationWriter(c)
    with NotationReader {
  override def writePretty(value: Any): String = value.asInstanceOf[String]

  override def writeRaw(value: Any): String = value.asInstanceOf[String]

  override def apply(s: String): Any = t(s)
}
