package pl.writeonly.son2.json.creators

import pl.writeonly.son2.core.config.{Provider, RWTConfig}
import pl.writeonly.son2.core.notation.PartialCreatorConfigSymbol
import pl.writeonly.son2.json.core.ConfigJson

class PCreatorConfigJson(f: Provider) extends PartialCreatorConfigSymbol(f.s) {
  override def apply(s: String): RWTConfig = ConfigJson(s)
}
