package pl.writeonly.son2.json.creators

import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.notation.NotationWriter
import pl.writeonly.son2.core.pcreators.PCreatorWriter
import pl.writeonly.son2.json.core.FormatsGson
import pl.writeonly.son2.json.notation.NotationWriterGson

class PCreatorWriterGson extends PCreatorWriter {
  override def isDefinedAt(c: WConfig): Boolean = FormatsGson.GSON.name.startsWith(c.format.name)

  override def apply(c: WConfig): NotationWriter = new NotationWriterGson(c)
}
