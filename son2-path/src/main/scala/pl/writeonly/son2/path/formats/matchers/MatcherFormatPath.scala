package pl.writeonly.son2.path.formats.matchers

import pl.writeonly.son2.core.formats.matchers.MatcherFormat
import pl.writeonly.son2.core.notation.NotationReader
import pl.writeonly.son2.path.core.Formats
import pl.writeonly.son2.path.notation.{NotationReaderPath, NotationReaderSmart, NotationReaderStrict}

class MatcherFormatPath() extends MatcherFormat[NotationReader] {
  def apply(s: String): Option[NotationReader] = s match {
    case s if path(s) => Option(new NotationReaderPath(s))
    case s if smart(s) => Option(new NotationReaderSmart())
    case s if strict(s) => Option(new NotationReaderStrict())
    case s => left(s)
  }

  def path(s:String) = s.startsWith("$")
  def smart(s:String) = Formats.SMART.name.startsWith(s)
  def strict(s:String) = Formats.STRICT.name.startsWith(s)
}
