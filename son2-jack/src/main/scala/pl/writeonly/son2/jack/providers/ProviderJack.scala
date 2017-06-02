package pl.writeonly.son2.jack.providers

import com.fasterxml.jackson.databind.ObjectMapper
import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.formats.MatcherFormatMapper
import pl.writeonly.son2.jack.notation.{NotationReaderJack, NotationWriterJack}

class ProviderJack(val config: Config, out: ObjectMapper)
  extends Provider (new Converter(new NotationReaderJack(MatcherFormatMapper(config)), new NotationWriterJack(out, config.p))) {

  override def equals(obj: scala.Any): Boolean = obj.isInstanceOf[ProviderJack] && config.equals(obj.asInstanceOf[ProviderJack].config)

  override def hashCode(): Int = config.hashCode()

  override def toString: String = " " + getClass + ", config " + config.toString
}
