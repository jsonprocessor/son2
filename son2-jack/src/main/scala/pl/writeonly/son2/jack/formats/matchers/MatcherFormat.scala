package pl.writeonly.son2.jack.formats.matchers

import pl.writeonly.son2.jack.formats.creators.CreatorFormat
import pl.writeonly.son2.jack.formats.predicates.PredicateFormat

abstract class MatcherFormat[F](p: PredicateFormat[F], c: CreatorFormat[F]) {
  def apply(s: String): Either[Option[String], F] = s match {
    case s if p.on(s) => Right(c.on)
    case s if p.yaml(s) => Right(c.yaml)
    case s if p.xml(s) => Right(c.xml)
    case s if p.csv(s) => Right(c.csv)
    case s if p.javaprops(s) => Right(c.javaprops)
    case s if p.properties(s) => Right(c.javaprops)
    case s => left(s)
  }

  def left(s: String): Either[Option[String], F] = Left(Option(s))

}
