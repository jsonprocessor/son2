package pl.writeonly.son2.core.glue

import pl.writeonly.son2.core.formats.matchers.MatcherFormat
import pl.writeonly.son2.core.notation.{NotationReader, NotationWriter}
import pl.writeonly.son2.core.providers.Provider

import scala.util.control.Exception.catching

abstract class MatcherFormatProvider(c: Config) {
  def w : MatcherFormat[NotationWriter]
  def r : MatcherFormat[NotationReader]

  def apply(): Either[Option[String], Provider] = catching(classOf[Exception])
    .either(new Provider(r.apply(c.i).right.get, w.apply(c.o).right.get)) match {
    case Right(r) => Right(r)
    case Left(l) => Left(Option(c.o))
  }

  def apply2(): Option[Provider] = catching(classOf[Exception])
    .opt(new Provider(r.apply(c.i).right.get, w.apply(c.o).right.get))

}

