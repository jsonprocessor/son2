package pl.writeonly.son2.apis.notation

import pl.writeonly.son2.apis.config.{Meta, WConfig}
import pl.writeonly.son2.apis.core.core.DString

class NotationTranslator(meta: Meta, c: WConfig, t: DString)
    extends NotationWriter(meta, c)
    with NotationReaderLike {
  override def writePretty(value: Value): String = value.asInstanceOf[String]

  override def writeRaw(value: Value): String = value.asInstanceOf[String]

  override def apply(s: String): Value = t(s)
}
