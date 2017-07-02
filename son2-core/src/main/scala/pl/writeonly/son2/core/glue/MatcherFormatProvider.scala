package pl.writeonly.son2.core.glue

import pl.writeonly.son2.core.formats.matchers.{ChainCreator}
import pl.writeonly.son2.core.providers.Provider

import scala.util.control.Exception.catching

abstract class MatcherFormatProvider(c: Config) {
  def r : ChainCreator
  def w : ChainCreator

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
                r : ChainCreator,
                w : ChainCreator
              ) = new Provider(c, r.apply(c.i).get.r, w.apply(c.o).get.w)
}

