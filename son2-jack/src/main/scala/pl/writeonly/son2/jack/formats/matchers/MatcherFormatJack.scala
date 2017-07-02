package pl.writeonly.son2.jack.formats.matchers

import pl.writeonly.son2.core.formats.matchers.MatcherFormat
import pl.writeonly.son2.jack.formats.creators.CreatorFormat
import pl.writeonly.son2.jack.formats.predicates.PredicateFormat

class MatcherFormatJack[F](p: PredicateFormat[F], c: CreatorFormat[F]) extends MatcherFormat[F] {
  def apply(s: String): Option[F] = s match {
    case s if p.on(s) => Option(c.on)
    case s if p.yaml(s) => Option(c.yaml)
    case s if p.xml(s) => Option(c.xml)
    case s if p.csv(s) => Option(c.csv)
    case s if p.javaprops(s) => Option(c.javaprops)
    case s if p.properties(s) => Option(c.javaprops)
    case s => left(s)
  }
}

