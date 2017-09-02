package pl.writeonly.son2.path.core

import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}
import pl.writeonly.son2.path.notation.{NotationReaderSmart, NotationReaderStrict, NotationWriterSmart, NotationWriterStrict}

abstract class Path(val format: Symbol, val reader: NotationReader, val writer: WConfig => NotationWriter)

case class SmartPath() extends Path(FormatsPath.SMART, new NotationReaderSmart, c => new NotationWriterSmart(c))

case class StrictPath() extends Path(FormatsPath.STRICT, new NotationReaderStrict, c => new NotationWriterStrict(c))

//case class GsonPath() extends Path(FormatsPath.GSON, new NotationReaderGson, c => new NotationWriterGson(c))
