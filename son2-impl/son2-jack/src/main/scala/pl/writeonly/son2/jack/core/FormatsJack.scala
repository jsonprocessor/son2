package pl.writeonly.son2.jack.core

import pl.writeonly.son2.core.config.Format
import pl.writeonly.son2.core.core.Formats

object FormatsJack extends Formats {
  val YAML = Format('yaml)
  val RISON = Format('rison)
  val HOCON = Format('hocon)
}
