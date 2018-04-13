package pl.writeonly.son2.path.notation

import com.google.gson.{Gson, GsonBuilder}
import com.jayway.jsonpath.spi.json.GsonJsonProvider
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider
import pl.writeonly.son2.apis.config.{MetaImpl, RConfig, WConfig}
import pl.writeonly.son2.apis.core.Formats
import pl.writeonly.son2.apis.notation.NotationWriter
import pl.writeonly.son2.path.core.{DefaultsPath, ProvidersPath}

case class NotationCaseGson()
    extends NotationCasePath(
      NotationCaseGson.meta,
      c => new NotationReaderPath(NotationCaseGson.meta, new DefaultsGson(c)),
      c => new NotationWriterGson(c)
    )

object NotationCaseGson {
  val meta = MetaImpl(ProvidersPath.GSON, Formats.OBJECT)
}

class DefaultsGson(c: RConfig, gson: Gson)
    extends DefaultsPath(
      c,
      new GsonJsonProvider(gson),
      new GsonMappingProvider(gson)
    ) {
  def this(c: RConfig) = this(c, new Gson())
}

class NotationWriterGson(c: WConfig)
    extends NotationWriter(NotationCaseGson.meta, c) {

  override def writePretty(value: Any): String =
    write(
      new GsonBuilder()
        .setPrettyPrinting()
        .create(),
      value
    )

  def write(gson: Gson, value: Any) = gson.toJson(value)

  override def writeRaw(value: Any): String = write(new Gson(), value)

}
