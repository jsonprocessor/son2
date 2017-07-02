package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.core.glue.{Config, ProviderCreator$}
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.core.ConfigJack
import pl.writeonly.son2.jack.creators.ChainCreatorJack

class ProviderCreatorJack(c: Config) extends ProviderCreator(c) {
  //  def t = new MatcherFormatTuple(new PredicateFormatStartsWith, (
  //    new CreatorFormatReader().asInstanceOf[CreatorFormat[Object]],
  //    new CreatorFormatWriter(c).asInstanceOf[CreatorFormat[Object]]))
  //  def r = new MatcherFormatJack(new PredicateFormatStartsWith, new CreatorFormatReader)
  //  def w = new MatcherFormatJack(new PredicateFormatStartsWith, new CreatorFormatWriter(c))
  def r = new ChainCreatorJack(c.p)

  def w = new ChainCreatorJack(c.p)

}

object ProviderCreatorJack {
  def apply(o: Symbol): Provider = apply(ConfigJack(o = o.name))

  def apply(config: Config): Provider = either(config)
    .right
    .get

  def either(config: Config): Either[Option[String], Provider] = new ProviderCreatorJack(config)
    .apply()

  //  def opt(config: Config): Option[Provider] = new FormatProvider(config).apply()

  def apply(o: String): Provider = apply(ConfigJack(o = o))


  //either
}
