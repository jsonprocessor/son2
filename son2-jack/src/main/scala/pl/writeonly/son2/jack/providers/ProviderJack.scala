package pl.writeonly.son2.jack.providers

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.converters.ConverterJack
import pl.writeonly.son2.jack.core.{Config, JsonNodeReader, JsonNodeWriter}
import pl.writeonly.son2.jack.formats.MatcherFormatMapper

class ProviderJack(val config: Config, out: ObjectMapper)
  extends Provider (new ConverterJack(new JsonNodeReader(MatcherFormatMapper(config)), new JsonNodeWriter(out, config.p))) {

  override def equals(obj: scala.Any): Boolean = obj.isInstanceOf[ProviderJack] && config.equals(obj.asInstanceOf[ProviderJack].config)

  override def hashCode(): Int = config.hashCode()

  override def toString: String = " " + getClass + ", config " + config.toString
}
