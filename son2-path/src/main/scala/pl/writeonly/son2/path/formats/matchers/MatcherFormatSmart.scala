package pl.writeonly.son2.path.formats.matchers

import pl.writeonly.son2.core.formats.matchers.MatcherFormat
import pl.writeonly.son2.core.notation.NotationWriter
import pl.writeonly.son2.path.notation.NotationWriterSmart

class MatcherFormatSmart(pretty : Boolean) extends MatcherFormat[NotationWriter] {
  def apply(s: String): Either[Option[String], NotationWriter] = s match {
    case s if smart(s) => Right(new NotationWriterSmart(pretty))
    case s => left(s)
  }

  def smart(s:String) = "SMART".startsWith(s)
  
}
