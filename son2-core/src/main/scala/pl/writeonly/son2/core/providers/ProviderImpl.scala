package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.converters.ConverterImpl
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}

class ProviderImpl(val in: NotationReader, val out: NotationWriter)
  extends Provider(new ConverterImpl(in, out)) {
}
