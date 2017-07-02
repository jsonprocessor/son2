package pl.writeonly.son2.path.glue

import pl.writeonly.son2.core.glue.{Config, ProviderCreator}
import pl.writeonly.son2.core.providers.Provider

class ProviderCreatorPath(c: Config) extends ProviderCreator(c) {
  def r = new ChainCreatorPath(c.p)
  def w = new ChainCreatorPath(c.p)
}

object ProviderCreatorPath {

  def apply(config: Config): Provider = either(config)
    .right
    .get


  def either(config: Config): Either[Option[String], Provider] = new ProviderCreatorPath(config)
    .apply()

}
