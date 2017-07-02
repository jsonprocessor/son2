package pl.writeonly.son2.path.formats.matchers

import pl.writeonly.son2.core.formats.matchers.MatcherFormat
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}
import pl.writeonly.son2.path.core.Formats
import pl.writeonly.son2.path.creators.{PartialCreatorPath, PartialCreatorSmart, PartialCreatorStrict}
import pl.writeonly.son2.path.notation.NotationWriterSmart

class MatcherFormatWriter(pretty : Boolean) extends MatcherFormat[NotationWriter] {

  def apply(s:String) : Option[NotationWriter] = new MatcherFormatPair(pretty).apply(s).map(_.w)

}
