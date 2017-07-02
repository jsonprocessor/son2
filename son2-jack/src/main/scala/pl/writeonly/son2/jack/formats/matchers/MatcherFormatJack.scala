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

  def a(s:String) : Option[F] = ???

}

class MatcherFormatTuple[F](p: PredicateFormat[F], c: Tuple2[CreatorFormat[F], CreatorFormat[F]]) extends MatcherFormat[(F,F)] {
  def apply(s: String): Option[(F,F)] = s match {
    case s if p.on(s) => Option((c._1.on, c._2.on))
    case s if p.yaml(s) => Option((c._1.yaml, c._2.yaml))
    case s if p.xml(s) => Option((c._1.xml, c._2.xml))
    case s if p.csv(s) => Option((c._1.csv, c._2.csv))
    case s if p.javaprops(s) => Option((c._1.javaprops, c._2.javaprops))
    case s if p.properties(s) => Option((c._1.javaprops, c._2.javaprops))
    case s => Option.empty
  }

  def a(s:String) : Option[F] = ???

}
