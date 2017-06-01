package pl.writeonly.son2.path.converters

import com.jayway.jsonpath.{Configuration, JsonPath}
import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.json.JsonWriter

class ConverterPath(val path : String, writer : JsonWriter) extends Converter {
  override def apply(content: String): String = {
    val conf = Configuration.defaultConfiguration();
    val value = JsonPath.using(conf).parse(content).read(path)
    writer.write(value)
  }
}
