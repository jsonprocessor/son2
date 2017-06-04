package pl.writeonly.son2.path.formats.matchers

import pl.writeonly.son2.path.notation.NotationReaderPath

class MatcherFormat[F]() {
  def apply(s: String): Either[Option[String], NotationReaderPath] = s match {
    case s if "$".startsWith(s) => Right(new NotationReaderPath(s))
    case s => left(s)
  }

  def left(s: String): Either[Option[String], NotationReaderPath] = Left(Option(s))

}
