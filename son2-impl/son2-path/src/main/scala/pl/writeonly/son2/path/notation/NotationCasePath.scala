package pl.writeonly.son2.path.notation

import pl.writeonly.son2.core.config.{ RConfig, WConfig }
import pl.writeonly.son2.core.notation.NotationWriter

abstract class NotationCasePath(
  val format: Symbol,
  val reader: RConfig => NotationReaderPath,
  val writer: WConfig => NotationWriter)
