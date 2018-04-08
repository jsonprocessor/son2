package pl.writeonly.son2.path.notation

import pl.writeonly.son2.apis.config.ProviderType
import pl.writeonly.son2.apis.core.core.FNotationWriter
import pl.writeonly.son2.path.core.FNotationReaderPath

abstract class NotationCasePath(val provider: ProviderType,
                                val reader: FNotationReaderPath,
                                val writer: FNotationWriter)
