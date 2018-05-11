package pl.writeonly.scallions.path.notation

import pl.writeonly.scallions.apis.config.Meta
import pl.writeonly.scallions.apis.core.core.FNotationWriter
import pl.writeonly.scallions.path.core.FNotationReaderPath

class NotationCasePath(val meta: Meta,
                       val reader: FNotationReaderPath,
                       val writer: FNotationWriter)
