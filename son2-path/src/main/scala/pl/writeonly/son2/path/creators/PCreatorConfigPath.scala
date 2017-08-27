package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.notation.PartialCreatorConfigSymbol
import pl.writeonly.son2.path.core.ConfigPath

class PCreatorConfigPath(f: Symbol) extends PartialCreatorConfigSymbol(f) {
  override def apply(s: String): Config = ConfigPath(o = Symbol(s))
}
