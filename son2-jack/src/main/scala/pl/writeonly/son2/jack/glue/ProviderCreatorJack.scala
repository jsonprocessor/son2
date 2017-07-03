package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.core.glue.{Config, ProviderCreator}
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.core.ConfigJack

class ProviderCreatorJack(c: Config) extends ProviderCreator(c) {

  def r = new ChainCreatorJack(c.p)

  def w = new ChainCreatorJack(c.p)

}

object ProviderCreatorJack {
  def apply(o: Symbol): Provider = apply(o.name)

  def apply(o: String): Provider = apply(ConfigJack(o = o))

  def apply(config: Config): Provider = either(config)
    .right
    .get

  def either(config: Config): Either[Option[String], Provider] = new ProviderCreatorJack(config)
    .apply()

}
