package pl.writeonly.son2.path.formats.matchers

import pl.writeonly.son2.core.formats.matchers.MatcherFormat
import pl.writeonly.son2.core.notation.NotationReader
import pl.writeonly.son2.path.creators.{PartialCreatorPath, PartialCreatorSmart, PartialCreatorStrict}

class MatcherFormatReader(pretty : Boolean) extends MatcherFormat[NotationReader] {

  def apply(s:String) : Option[NotationReader] = (
      new PartialCreatorPath
        orElse
      new PartialCreatorSmart(pretty)
        orElse
      new PartialCreatorStrict(pretty)
    ).lift(s).map(_._1)

}
