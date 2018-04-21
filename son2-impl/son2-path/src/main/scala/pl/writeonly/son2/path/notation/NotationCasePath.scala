package pl.writeonly.son2.path.notation

import pl.writeonly.son2.apis.config.Meta
import pl.writeonly.son2.apis.core.core.FNotationWriter
import pl.writeonly.son2.path.core.FNotationReaderPath

class NotationCasePath(val meta: Meta,
                       val reader: FNotationReaderPath,
                       val writer: FNotationWriter)
