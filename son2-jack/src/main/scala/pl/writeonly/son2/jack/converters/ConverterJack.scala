package pl.writeonly.son2.jack.converters

import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.jack.core.{JsonNodeReader, JsonNodeWriter}

class ConverterJack(val in: JsonNodeReader, val out: JsonNodeWriter) extends Converter {

  def apply(content: String): String = out.writeValueAsString(in.readTree(content))

}