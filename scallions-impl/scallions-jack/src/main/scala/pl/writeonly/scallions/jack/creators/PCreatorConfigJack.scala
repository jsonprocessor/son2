package pl.writeonly.scallions.jack.creators

import pl.writeonly.scallions.apis.config.Format
import pl.writeonly.scallions.jack.core.ConfigJack
import pl.writeonly.scallions.apis.config.RWTConfig
import pl.writeonly.scallions.apis.notation.PartialCreatorConfigSymbol

class PCreatorConfigJack(f: Format) extends PartialCreatorConfigSymbol(f.s) {
  override def apply(s: String): RWTConfig = ConfigJack(s)
}
