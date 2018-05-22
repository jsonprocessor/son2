package pl.writeonly.scallions.apis.notation

import pl.writeonly.scallions.apis.config.{Meta, WConfig}
import pl.writeonly.scallions.apis.core.DString

class NotationTranslator(meta: Meta, c: WConfig, t: DString)
    extends NotationWriter(meta, c)
    with NotationReaderLike {
  override def writePretty(value: Value): String = value.asInstanceOf[String]

  override def writeRaw(value: Value): String = value.asInstanceOf[String]

  override def apply(s: String): Value = t(s)
}
