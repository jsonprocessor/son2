package pl.writeonly.son2.jack.formats.matchers

import pl.writeonly.son2.jack.formats.creators.CreatorFormat

abstract class MatcherFormat[F](c: CreatorFormat[F]) {
  def apply(s: String): Either[Option[String], F] = s match {
    case s if on(s) => Right(c.on)
    case s if yaml(s) => Right(c.yaml)
    case s if xml(s) => Right(c.xml)
    case s if csv(s) => Right(c.csv)
    case s if javaprops(s) => Right(c.javaprops)
    case s if properties(s) => Right(c.javaprops)
    case s => left(s)
  }

  def left(s: String): Either[Option[String], F] = Left(Option(s))

  def on(s: String): Boolean

  def yaml(s: String): Boolean

  def xml(s: String): Boolean

  def csv(s: String): Boolean

  def javaprops(s: String): Boolean

  def properties(s: String): Boolean

}
