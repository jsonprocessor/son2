package pl.writeonly.son2.gson.creators

import pl.writeonly.son2.core.config.RConfig
import pl.writeonly.son2.core.notation.NotationReader
import pl.writeonly.son2.core.pcreators.PCreatorReader
import pl.writeonly.son2.gson.core.FormatsGson
import pl.writeonly.son2.gson.notation.NotationReaderGson

class PartialCreatorReaderGson extends PCreatorReader {
  override def isDefinedAt(c: RConfig): Boolean = FormatsGson.GSON.name.startsWith(c.format.name)

  override def apply(c: RConfig): NotationReader = new NotationReaderGson()
}
