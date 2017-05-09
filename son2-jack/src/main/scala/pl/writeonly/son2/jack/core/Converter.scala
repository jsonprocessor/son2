package pl.writeonly.son2.jack.core

class Converter(val in: JsonNodeReader, val out: JsonNodeWriter) {

  def apply(content: String): String = out.writeValueAsString(in.readTree(content))

}