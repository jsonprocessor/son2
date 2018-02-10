package pl.writeonly.son2.path.notation

import pl.writeonly.son2.core.core.FNotationWriter
import pl.writeonly.son2.path.core.FNotationReaderPath

abstract class NotationCasePath(val format: Symbol,
                                val reader: FNotationReaderPath,
                                val writer: FNotationWriter)
