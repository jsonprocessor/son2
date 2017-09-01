package pl.writeonly.son2.json.notation

import com.google.gson.{Gson, GsonBuilder}
import pl.writeonly.son2.core.config.WConfig
import pl.writeonly.son2.core.notation.NotationWriter

class NotationWriterGson(c: WConfig)
  extends NotationWriter(c) {

  override def writePretty(value: Any): String = write(new GsonBuilder()
    .setPrettyPrinting()
    .create(), value)

  override def writeRaw(value: Any): String = write(new Gson(), value)

  def write(gson : Gson, value: Any) = gson.toJson(value)

}
