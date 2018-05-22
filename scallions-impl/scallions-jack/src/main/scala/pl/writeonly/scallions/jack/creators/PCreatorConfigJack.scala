package pl.writeonly.scallions.jack.creators

import pl.writeonly.scallions.apis.config.{Format, RWTConfig}
import pl.writeonly.scallions.apis.notation.PartialCreatorConfigSymbol
import pl.writeonly.scallions.jack.core.ConfigJack

class PCreatorConfigJack(f: Format) extends PartialCreatorConfigSymbol(f.s) {
  override def apply(s: String): RWTConfig = ConfigJack(s)
}
