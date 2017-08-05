package pl.writeonly.son2.core.glue

import org.scalactic.{ErrorMessage, Or}
import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.providers.Provider

abstract class CreatorProviderOr {
  def providerOr(s: String): Provider Or ErrorMessage
  def configOpt(s: String): Option[Config]
}
