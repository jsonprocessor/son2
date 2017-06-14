package pl.writeonly.son2.path.formats.matchers

import pl.writeonly.son2.core.formats.matchers.MatcherFormat
import pl.writeonly.son2.core.notation.NotationReader
import pl.writeonly.son2.path.core.Formats
import pl.writeonly.son2.path.notation.{NotationReaderPath, NotationReaderSmart, NotationReaderStrict}

class MatcherFormatPath() extends MatcherFormat[NotationReader] {
  def apply(s: String): Either[Option[String], NotationReader] = s match {
    case s if predicate(s) => Right(new NotationReaderPath(s))
    case s if smart(s) => Right(new NotationReaderSmart())
    case s if strict(s) => Right(new NotationReaderStrict())
    case s => left(s)
  }

  def predicate(s:String) = s.startsWith("$")
  def smart(s:String) = Formats.SMART.name.startsWith(s)
  def strict(s:String) = Formats.STRICT.name.startsWith(s)
}
