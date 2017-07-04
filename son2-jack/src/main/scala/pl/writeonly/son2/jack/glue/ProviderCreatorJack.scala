package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.core.glue.ProviderCreator
import pl.writeonly.son2.core.notation.Config
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.chain.ChainNotationPairJack
import pl.writeonly.son2.jack.core.ConfigJack

class ProviderCreatorJack(c: Config) extends ProviderCreator(c) {

  def r = new ChainNotationPairJack(c.p)

  def w = new ChainNotationPairJack(c.p)

}

object ProviderCreatorJack {
  def apply(o: Symbol): Provider = apply(ConfigJack(o.name))

  //  def apply(f: String): Provider = apply(ConfigJack(o = o))

  def apply(config: Config): Provider = either(config)
    .right
    .get

  def either(config: Config): Either[Option[String], Provider] = new ProviderCreatorJack(config)
    .apply()

}
