package pl.writeonly.son2.core.formats.matchers

trait MatcherFormat[F] {
  def apply(s: String): Option[F]
}
