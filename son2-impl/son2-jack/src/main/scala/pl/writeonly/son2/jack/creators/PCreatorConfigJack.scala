package pl.writeonly.son2.jack.creators

import pl.writeonly.son2.apis.config.{Format, RWTConfig}
import pl.writeonly.son2.apis.notation.PartialCreatorConfigSymbol
import pl.writeonly.son2.jack.core.ConfigJack

class PCreatorConfigJack(f: Format) extends PartialCreatorConfigSymbol(f.s) {
  override def apply(s: String): RWTConfig = ConfigJack(s)
}
