package pl.writeonly.son2.path.formats.matchers

import pl.writeonly.son2.core.formats.matchers.MatcherFormat
import pl.writeonly.son2.core.notation.{NotationPair, NotationReader, NotationWriter}
import pl.writeonly.son2.path.creators.{PartialCreatorPath, PartialCreatorSmart, PartialCreatorStrict}

class MatcherFormatPair(pretty : Boolean) extends MatcherFormat[NotationPair] {

  def apply(s:String) : Option[NotationPair] = get.lift(s)

  def get = (
    new PartialCreatorPath
      orElse
      new PartialCreatorSmart(pretty)
      orElse
      new PartialCreatorStrict(pretty)
    )

}
