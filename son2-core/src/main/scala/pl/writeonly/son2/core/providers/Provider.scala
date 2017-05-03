package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.core.{Config, Converter, JsonNodeReader, JsonNodeWriter}
import pl.writeonly.son2.core.formats.MatcherFormatMapper

class Provider(config: Config, out: ObjectMapper) {
  val converter = new Converter(new JsonNodeReader(MatcherFormatMapper(config)), new JsonNodeWriter(out, config.p))

  def convert(s: String) = converter.apply(s)

  def comment(s: String) = s
}
