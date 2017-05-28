package pl.writeonly.son2.jack.providers

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.jack.core.{Config, Converter, JsonNodeReader, JsonNodeWriter}
import pl.writeonly.son2.jack.formats.MatcherFormatMapper

class Provider(val config: Config, out: ObjectMapper) {
  val converter = new Converter(new JsonNodeReader(MatcherFormatMapper(config)), new JsonNodeWriter(out, config.p))

  def convert(s: String) = converter.apply(s)

  def comment(s: String) = s

  override def equals(obj: scala.Any): Boolean = obj.isInstanceOf[Provider] && config.equals(obj.asInstanceOf[Provider].config)

  override def hashCode(): Int = config.hashCode()

  override def toString: String = " " + getClass + ", config " + config.toString
}
