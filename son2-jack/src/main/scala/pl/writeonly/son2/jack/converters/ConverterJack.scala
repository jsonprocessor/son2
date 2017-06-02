package pl.writeonly.son2.jack.converters

import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.json.{JsonReader, JsonWriter}

class ConverterJack(val in: JsonReader, val out: JsonWriter) extends Converter {

  def apply(content: String): String = out.write(in.readTree(content))

}
