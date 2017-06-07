package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.core.glue.{Config, MatcherFormatProvider}
import pl.writeonly.son2.jack.core.ConfigJack
import pl.writeonly.son2.jack.formats.creators.{CreatorFormatReader, CreatorFormatWriter}
import pl.writeonly.son2.jack.formats.matchers.MatcherFormatJack
import pl.writeonly.son2.jack.formats.predicates.PredicateFormatStartsWith
import pl.writeonly.son2.jack.providers._

import scala.util.control.Exception.catching

class MatcherFormatProviderJack(c: Config) extends MatcherFormatProvider(c) {
  def w = new MatcherFormatJack(new PredicateFormatStartsWith, new CreatorFormatWriter(c))
  def r = new MatcherFormatJack(new PredicateFormatStartsWith, new CreatorFormatReader())

  override def apply(): Either[Option[String], ProviderJack] = catching(classOf[Exception])
    .either(new ProviderJack(r.apply(c.i).right.get, w.apply(c.o).right.get)) match {
    case Right(r) => Right(r)
    case Left(l) => Left(Option(c.o))
  }

  override def apply2(): Option[ProviderJack] = catching(classOf[Exception])
    .opt(new ProviderJack(r.apply(c.i).right.get, w.apply(c.o).right.get))

}

object MatcherFormatProviderJack {
  def apply(o: String): ProviderJack = apply(ConfigJack(o = o))

  def apply(config: Config): ProviderJack = either(config)
    .right
    .get

  //  def opt(config: Config): Option[Provider] = new FormatProvider(config).apply()

  def either(config: Config): Either[Option[String], ProviderJack] = new MatcherFormatProviderJack(config)
    .apply()

  //either
}
