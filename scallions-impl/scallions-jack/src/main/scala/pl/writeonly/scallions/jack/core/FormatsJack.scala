package pl.writeonly.scallions.jack.core

import pl.writeonly.scallions.apis.config.Format
import pl.writeonly.scallions.apis.core.Formats

object FormatsJack extends Formats {
  val YAML = Format('yaml)
  val RISON = Format('rison)
  val HOCON = Format('hocon)
}
