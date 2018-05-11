package pl.writeonly.scallions.json.creators

import pl.writeonly.scallions.apis.config.ProviderType
import pl.writeonly.scallions.json.core.ConfigJson
import pl.writeonly.scallions.apis.config.RWTConfig
import pl.writeonly.scallions.apis.notation.PartialCreatorConfigSymbol

class PCreatorConfigJson(f: ProviderType)
    extends PartialCreatorConfigSymbol(f.s) {
  override def apply(s: String): RWTConfig = ConfigJson(s)
}
