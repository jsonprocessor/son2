package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter, PartialCreatorPair}
import pl.writeonly.son2.path.core.Formats
import pl.writeonly.son2.path.notation.{NotationReaderSmart, NotationWriterSmart}

class PartialCreatorSmart(pretty: Boolean) extends PartialCreatorPair {
  override def format: Symbol = Formats.SMART

  override def c: (String) => Config = s => new Config(i = s, o = s, p = true)

  override def r: NotationReader = new NotationReaderSmart()

  override def w: NotationWriter = new NotationWriterSmart(pretty)

}
