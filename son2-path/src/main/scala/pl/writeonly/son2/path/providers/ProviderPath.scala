package pl.writeonly.son2.path.providers

import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.notation.NotationWriter
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.path.notation.NotationReaderPath

class ProviderPath(path : String, writer : NotationWriter)
  extends Provider(new Converter(new NotationReaderPath(path), writer)) {

}
