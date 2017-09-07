package pl.writeonly.son2.path.notation

import com.jayway.jsonpath.spi.json.JsonProvider
import pl.writeonly.son2.core.notation.NotationReader

class NotationReaderProvider(provider : JsonProvider) extends NotationReader {
  override def apply(content: String): Any = provider.parse(content)
}
