package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.Converter
import pl.writeonly.son2.core.node.{JsonNodeReader, JsonNodeWriter}

class Provider(out:ObjectMapper){
  val converter = new Converter(new JsonNodeReader(new ObjectMapper()), new JsonNodeWriter(out, true))

  def convert(s: String) = converter.apply(s)

  def comment(s: String) = s
}
