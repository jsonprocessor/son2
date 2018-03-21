package pl.writeonly.son2.json.creators

import pl.writeonly.son2.apis.config.{Provider, RWTConfig}
import pl.writeonly.son2.apis.notation.PartialCreatorConfigSymbol
import pl.writeonly.son2.json.core.ConfigJson

class PCreatorConfigJson(f: Provider) extends PartialCreatorConfigSymbol(f.s) {
  override def apply(s: String): RWTConfig = ConfigJson(s)
}
