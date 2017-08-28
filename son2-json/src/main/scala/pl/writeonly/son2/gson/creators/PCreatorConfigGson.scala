package pl.writeonly.son2.gson.creators

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.notation.PartialCreatorConfigSymbol
import pl.writeonly.son2.gson.core.{ConfigGson, FormatsGson}

class PCreatorConfigGson extends PartialCreatorConfigSymbol(FormatsGson.GSON) {
  override def apply(s: String): Config = ConfigGson(s)
}
