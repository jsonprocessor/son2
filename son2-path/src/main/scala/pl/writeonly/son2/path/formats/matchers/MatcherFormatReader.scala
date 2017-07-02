package pl.writeonly.son2.path.formats.matchers

import pl.writeonly.son2.core.formats.matchers.MatcherFormat
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}

class MatcherFormatReader(pretty : Boolean) extends MatcherFormat[NotationReader] {

  def apply(s:String) : Option[NotationReader] = new ChainCreatorPath(pretty).apply(s).map(_.r)

}
