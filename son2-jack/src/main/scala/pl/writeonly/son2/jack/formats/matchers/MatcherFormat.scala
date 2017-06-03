package pl.writeonly.son2.jack.formats.matchers

import pl.writeonly.son2.jack.formats.creators.CreatorFormat
import pl.writeonly.son2.jack.formats.predicates.PredicateFormat

abstract class MatcherFormat[F](c: CreatorFormat[F]) extends PredicateFormat[F] {
  def apply(s: String): Either[Option[String], F] = s match {
    case s if on(s) => Right(c.on)
    case s if yaml(s) => Right(c.yaml)
    case s if xml(s) => Right(c.xml)
    case s if csv(s) => Right(c.csv)
    case s if javaprops(s) => Right(c.javaprops)
    case s if properties(s) => Right(c.javaprops)
    case s => left(s)
  }

  override def left(s: String): Either[Option[String], F] = Left(Option(s))

}
