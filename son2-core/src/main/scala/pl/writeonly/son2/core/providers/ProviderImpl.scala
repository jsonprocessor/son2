package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.converters.ConverterImpl
import pl.writeonly.son2.core.json.{JsonReader, JsonWriter}

class ProviderImpl(val in: JsonReader, val out: JsonWriter)
  extends Provider(new ConverterImpl(in, out)) {
}
