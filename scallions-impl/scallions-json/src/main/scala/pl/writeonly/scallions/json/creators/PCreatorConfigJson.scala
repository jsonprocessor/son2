package pl.writeonly.scallions.json.creators

import pl.writeonly.scallions.apis.config.{ProviderType, RWTConfig}
import pl.writeonly.scallions.apis.notation.PartialCreatorConfigSymbol
import pl.writeonly.scallions.json.core.ConfigJson

class PCreatorConfigJson(f: ProviderType)
    extends PartialCreatorConfigSymbol(f.s) {
  override def apply(s: String): RWTConfig = ConfigJson(s)
}
