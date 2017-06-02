package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}

class ProviderImpl(val in: NotationReader, val out: NotationWriter)
  extends Provider(new Converter(in, out)) {
}
