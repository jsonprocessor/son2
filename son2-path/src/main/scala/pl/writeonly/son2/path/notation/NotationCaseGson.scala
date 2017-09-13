package pl.writeonly.son2.path.notation

import com.google.gson.{Gson, GsonBuilder, JsonElement, JsonParser}
import com.jayway.jsonpath.spi.json.GsonJsonProvider
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider
import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}
import pl.writeonly.son2.path.core.FormatsPath

case class NotationCaseGson()
  extends NotationCasePath(FormatsPath.GSON,
    new NotationReaderGson, c => new NotationWriterGson(c),
    new GsonJsonProvider(), new GsonMappingProvider())

class NotationReaderGson() extends NotationReader {
  def apply(content: String): JsonElement = new JsonParser().parse(content)
}

class NotationWriterGson(c: WConfig)
  extends NotationWriter(c) {

  override def writePretty(value: Any): String = write(new GsonBuilder()
    .setPrettyPrinting()
    .create(), value)

  override def writeRaw(value: Any): String = write(new Gson(), value)

  def write(gson: Gson, value: Any) = gson.toJson(value)

}
