package pl.writeonly.son2.core

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.node.{JsonNodeReader, JsonNodeWriter}

class Converter(val in:JsonNodeReader, val out:JsonNodeWriter) {
  def this(in:ObjectMapper, out :ObjectMapper, pretty :Boolean) = this(new JsonNodeReader(in), new JsonNodeWriter(out,pretty ))

  def apply(content: String):String = out.writeValueAsString(in.readTree(content))

}