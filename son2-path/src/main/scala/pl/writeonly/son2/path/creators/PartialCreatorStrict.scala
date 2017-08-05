package pl.writeonly.son2.path.creators

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter, PartialCreatorPair}
import pl.writeonly.son2.path.core.Formats
import pl.writeonly.son2.path.notation.{NotationReaderStrict, NotationWriterStrict}

class PartialCreatorStrict(pretty: Boolean) extends PartialCreatorPair {
  override def format: Symbol = Formats.STRICT

  override def c: (String) => Config = s => new Config(input = s, output = s, pretty = false)

  override def r(s: String): NotationReader = new NotationReaderStrict()

  override def w(s: String): NotationWriter = new NotationWriterStrict(pretty)


}
