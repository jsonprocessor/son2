package pl.writeonly.son2.core.glue

import org.scalactic.{ErrorMessage, Or}
import pl.writeonly.son2.core.providers.Provider

abstract class CreatorProviderOr {
  def provider(s: String): Provider Or ErrorMessage
}
