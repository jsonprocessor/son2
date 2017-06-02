package pl.writeonly.son2.core.converters

import pl.writeonly.son2.core.json.{JsonReader, JsonWriter}

class ConverterImpl(val in: JsonReader, val out: JsonWriter) extends Converter {

  def apply(content: String): String = out.write(in.readTree(content))

}
