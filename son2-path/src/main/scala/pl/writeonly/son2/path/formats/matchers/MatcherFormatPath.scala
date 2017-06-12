package pl.writeonly.son2.path.formats.matchers

import pl.writeonly.son2.core.formats.matchers.MatcherFormat
import pl.writeonly.son2.core.notation.NotationReader
import pl.writeonly.son2.path.notation.{NotationReaderPath, NotationReaderSmart}

class MatcherFormatPath() extends MatcherFormat[NotationReader] {
  def apply(s: String): Either[Option[String], NotationReader] = s match {
    case s if predicate(s) => Right(new NotationReaderPath(s))
    case s if smart(s) => Right(new NotationReaderSmart(s))
    case s => left(s)
  }

  def predicate(s:String) = "$".startsWith(s)
  def smart(s:String) = "smart".startsWith(s)


}
