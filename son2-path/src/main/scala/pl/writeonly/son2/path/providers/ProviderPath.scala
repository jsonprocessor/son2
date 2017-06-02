package pl.writeonly.son2.path.providers

import pl.writeonly.son2.core.notation.NotationWriter
import pl.writeonly.son2.core.providers.ProviderImpl
import pl.writeonly.son2.path.notation.NotationReaderPath

class ProviderPath(path : String, writer : NotationWriter)
  extends ProviderImpl(new NotationReaderPath(path), writer) {

}
