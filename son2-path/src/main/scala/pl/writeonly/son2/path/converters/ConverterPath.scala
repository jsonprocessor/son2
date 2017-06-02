package pl.writeonly.son2.path.converters

import pl.writeonly.son2.core.converters.ConverterImpl
import pl.writeonly.son2.core.notation.NotationWriter
import pl.writeonly.son2.path.notation.NotationReaderPath

class ConverterPath(val path : String, writer : NotationWriter)
  extends ConverterImpl(new NotationReaderPath(path), writer) {
}
