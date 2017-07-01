package pl.writeonly.son2.path.formats.matchers

import pl.writeonly.son2.core.formats.matchers.MatcherFormat
import pl.writeonly.son2.core.notation.NotationWriter
import pl.writeonly.son2.path.core.Formats
import pl.writeonly.son2.path.notation.NotationWriterSmart

class MatcherFormatSmart(pretty : Boolean) extends MatcherFormat[NotationWriter] {
  def apply(s: String): Option[NotationWriter] = s match {
    case s if smart(s) => Option(new NotationWriterSmart(pretty))
    case s => left(s)
  }

  def smart(s:String) = Formats.SMART.name.startsWith(s)

}
