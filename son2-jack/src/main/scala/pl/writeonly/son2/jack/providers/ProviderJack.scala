package pl.writeonly.son2.jack.providers

import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.formats.MatcherFormatMapper
import pl.writeonly.son2.jack.notation.NotationReaderJack

class ProviderJack(in: NotationReader, out: NotationWriter)
  extends Provider (new Converter(in: NotationReader, out: NotationWriter)) {

  def this (config: Config, out: NotationWriter) = this(new NotationReaderJack(MatcherFormatMapper(config)), out)

}
