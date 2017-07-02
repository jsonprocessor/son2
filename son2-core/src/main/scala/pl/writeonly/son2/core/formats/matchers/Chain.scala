package pl.writeonly.son2.core.formats.matchers


trait Chain[F] extends MatcherFormat[F] {
  def apply(s: String): Option[F] = get.lift(s)

  def get: PartialFunction[String, F]
}
