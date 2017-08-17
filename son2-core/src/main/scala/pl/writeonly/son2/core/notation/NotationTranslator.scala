package pl.writeonly.son2.core.notation

import pl.writeonly.son2.core.config.WConfig

class NotationTranslator(c:WConfig, t: String => String) extends NotationWriter(c, true) with NotationReader {
  override def writePretty(value: Any): String = value.asInstanceOf[String]

  override def writeRaw(value: Any): String = value.asInstanceOf[String]

  override def apply(s: String): Any = t(s)
}
