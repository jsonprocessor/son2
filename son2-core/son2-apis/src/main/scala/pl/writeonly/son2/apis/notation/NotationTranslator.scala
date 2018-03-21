package pl.writeonly.son2.apis.notation

import pl.writeonly.son2.apis.config.WConfig
import pl.writeonly.son2.apis.core.core.DString

class NotationTranslator(c: WConfig, t: DString)
    extends NotationWriter(c)
    with NotationReader {
  override def writePretty(value: Any): String = value.asInstanceOf[String]

  override def writeRaw(value: Any): String = value.asInstanceOf[String]

  override def apply(s: String): Any = t(s)
}
