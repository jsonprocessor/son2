package pl.writeonly.son2.jack.core

import pl.writeonly.son2.core.Converter

class ConverterJack(val in: JsonNodeReader, val out: JsonNodeWriter) extends Converter {

  def apply(content: String): String = out.writeValueAsString(in.readTree(content))

}