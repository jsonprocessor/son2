package pl.writeonly.son2.jack.converters

import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.jack.core.{JsonNodeReader, JsonWriterJack}

class ConverterJack(val in: JsonNodeReader, val out: JsonWriterJack) extends Converter {

  def apply(content: String): String = out.write(in.readTree(content))

}