package pl.writeonly.son2.jack.creators

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.notation.PartialCreatorConfigSymbol
import pl.writeonly.son2.jack.core.ConfigJack

class PCreatorConfigJack(f: Symbol) extends PartialCreatorConfigSymbol(f) {
  override def apply(s: String): Config = ConfigJack(s)
}
