package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.config.{Config, RConfig, WConfig}
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter, PartialCreatorPair}
import pl.writeonly.son2.path.core.Formats
import pl.writeonly.son2.path.notation.{NotationReaderSmart, NotationWriterSmart}

class PartialCreatorSmart(pretty: Boolean) extends PartialCreatorPair {
  override def format: Symbol = Formats.SMART

  override def c: (String) => Config = s => new Config(
    read = RConfig(format = Symbol(s)), write = WConfig(format = Symbol(s), style = true)
  )

  override def r(s: String): NotationReader = new NotationReaderSmart()

  override def w(s: String): NotationWriter = new NotationWriterSmart(pretty)

}
