package pl.writeonly.son2.gson.creators

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.notation.PartialCreatorConfigSymbol

class PCreatorConfigJack(f: Symbol) extends PartialCreatorConfigSymbol(f) {
  override def apply(s: String): Config = ConfigJack(s)
}
