package pl.writeonly.son2.text.notation

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.notation.PartialCreatorPair
import pl.writeonly.son2.text.core.Formats

abstract class PartialCreatorUnescapeJava(pretty: Boolean) extends PartialCreatorPair {
  override def format: Symbol = Formats.JAVA

  override def c: (String) => Config = s => new Config(i = s, o = s, p = true)

//  override def r: NotationReader = new NotationReaderSmart()
//
//  override def w: NotationWriter = new NotationWriterSmart(pretty)

}
