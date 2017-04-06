package pl.writeonly.son2.core

import pl.writeonly.son2.core.node.{JsonNodeReader, JsonNodeWriter}

class Converter(val in: JsonNodeReader, val out: JsonNodeWriter) {

  def apply(content: String): String = out.writeValueAsString(in.readTree(content))

}