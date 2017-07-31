package pl.writeonly.son2.text.creators

import pl.writeonly.son2.core.notation.{NotationPair, PartialCreator}

class PartialCreatorText extends PartialCreator {

  override def isDefinedAt(s: String) = s != null && regex(s).isDefined

  override def apply(s: String) = ???

  private def regex(s:String) = "$(\\w+)_(\\w+)^".r.findFirstMatchIn(s)


}
