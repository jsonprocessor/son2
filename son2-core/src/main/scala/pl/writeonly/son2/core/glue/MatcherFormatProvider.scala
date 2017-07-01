package pl.writeonly.son2.core.glue

import pl.writeonly.son2.core.formats.matchers.MatcherFormat
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}
import pl.writeonly.son2.core.providers.Provider

import scala.util.control.Exception.catching

abstract class MatcherFormatProvider(c: Config) {
  def r : MatcherFormat[_<:NotationReader]
  def w : MatcherFormat[_<:NotationWriter]

  def apply(): Either[Option[String], Provider] = catching(classOf[Exception])
    .either(MatcherFormatProvider.provider(c, r, w)) match {
    case Right(r) => Right(r)
    case Left(l) => Left(Option(c.o))
  }

  def apply2(): Option[Provider] = catching(classOf[Exception])
    .opt(MatcherFormatProvider.provider(c, r, w))

}

object MatcherFormatProvider {
  def provider(
                c : Config,
                r : MatcherFormat[_<:NotationReader],
                w : MatcherFormat[_<:NotationWriter]
              ) = new Provider(c, r.apply(c.i).get, w.apply(c.o).get)
}

