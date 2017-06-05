package pl.writeonly.son2.core.formats.matchers

trait MatcherFormat[F] {
  def apply(s: String): Either[Option[String], F]
  def left(s: String): Either[Option[String], F] = Left(Option(s))
}
