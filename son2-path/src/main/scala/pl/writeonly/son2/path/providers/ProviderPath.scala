package pl.writeonly.son2.path.providers

import pl.writeonly.son2.core.json.JsonWriter
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.path.converters.ConverterPath

class ProviderPath(path : String, writer : JsonWriter)
  extends Provider(new ConverterPath(path, writer)) {

}
