package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.formats.creators.{CreatorFormatReader, CreatorFormatWriter}
import pl.writeonly.son2.jack.formats.matchers.MatcherFormatJack
import pl.writeonly.son2.jack.formats.predicates.PredicateFormatStartsWith
import pl.writeonly.son2.jack.providers._

import scala.util.control.Exception.catching

class MatcherFormatProvider(c: Config) {
  val w = new MatcherFormatJack(new PredicateFormatStartsWith, new CreatorFormatWriter(c))
  val r = new MatcherFormatJack(new PredicateFormatStartsWith, new CreatorFormatReader())

  def apply(): Either[Option[String], ProviderJack] = catching(classOf[Exception])
    .either(new ProviderJack(r.apply(c.i).right.get, w.apply(c.o).right.get)) match {
    case Right(r) => Right(r)
    case Left(l) => Left(Option(c.o))
  }

  def apply2(): Option[ProviderJack] = catching(classOf[Exception])
    .opt(new ProviderJack(r.apply(c.i).right.get, w.apply(c.o).right.get))

}

object MatcherFormatProvider {
  def apply(o: String): ProviderJack = apply(Config(o = o))

  def apply(config: Config): ProviderJack = either(config)
    .right
    .get

  //  def opt(config: Config): Option[Provider] = new FormatProvider(config).apply()

  def either(config: Config): Either[Option[String], ProviderJack] = new MatcherFormatProvider(config)
    .apply()

  //either
}
