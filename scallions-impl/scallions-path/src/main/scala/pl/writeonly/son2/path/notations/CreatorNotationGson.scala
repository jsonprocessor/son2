package pl.writeonly.son2.path.notations

import com.google.gson.{Gson, GsonBuilder}
import com.jayway.jsonpath.spi.json.GsonJsonProvider
import com.jayway.jsonpath.spi.mapper.GsonMappingProvider
import pl.writeonly.son2.apis.config.{Meta, RConfig, WConfig}
import pl.writeonly.son2.apis.core.Formats
import pl.writeonly.son2.apis.notation.{NotationWriter, Value}
import pl.writeonly.son2.path.core.ProvidersPath
import pl.writeonly.son2.path.notation.{CreatorNotation, NotationReaderPath}

object CreatorNotationGson extends CreatorNotation {

  val meta: Meta = Meta(ProvidersPath.GSON, Formats.OBJECT)

  val gson = new Gson()

  override def jsonProvider = new GsonJsonProvider(gson)

  override def mappingProvider = new GsonMappingProvider(gson)

  def reader(c: RConfig) = new NotationReaderPath(meta, defaultsPath(c))

  def writer(c: WConfig) = new NotationWriterGson(c)

  class NotationWriterGson(c: WConfig) extends NotationWriter(meta, c) {

    override def writePretty(value: Value): String =
      write(
        new GsonBuilder()
          .setPrettyPrinting()
          .create(),
        value
      )

    def write(gson: Gson, value: Any): String = gson.toJson(value)

    override def writeRaw(value: Value): String = write(new Gson(), value)

  }

}
