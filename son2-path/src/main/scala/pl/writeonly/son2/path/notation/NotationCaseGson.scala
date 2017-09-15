package pl.writeonly.son2.path.notation

import com.google.gson.{Gson, GsonBuilder, JsonElement, JsonParser}
import com.jayway.jsonpath.spi.json.GsonJsonProvider
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider
import pl.writeonly.son2.core.config.{RConfig, WConfig}
import pl.writeonly.son2.core.notation.{ NotationWriter}
import pl.writeonly.son2.path.core.FormatsPath
import pl.writeonly.son2.path.defaults.{ DefaultsPath}

case class NotationCaseGson()
  extends NotationCasePath(FormatsPath.GSON,
    c => new NotationReaderGson(c),
    c => new NotationWriterGson(c))

class NotationReaderGson(c: RConfig)
  extends NotationReaderPath(new DefaultsGson(c), c.query)

class DefaultsGson(c:RConfig, gson: Gson)
  extends DefaultsPath(c, new GsonJsonProvider(gson), new GsonMappingProvider(gson)) {
  def this(c:RConfig) = this(c, new Gson())
}

class NotationWriterGson(c: WConfig)
  extends NotationWriter(c) {

  override def writePretty(value: Any): String = write(new GsonBuilder()
    .setPrettyPrinting()
    .create(), value)

  override def writeRaw(value: Any): String = write(new Gson(), value)

  def write(gson: Gson, value: Any) = gson.toJson(value)

}
