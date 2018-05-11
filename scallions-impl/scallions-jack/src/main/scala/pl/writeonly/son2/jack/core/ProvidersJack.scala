package pl.writeonly.son2.jack.core

import pl.writeonly.son2.apis.config.ProviderType

trait ProvidersJack {
  val JACKSON = ProviderType('jackson)
}

object ProvidersJack extends ProvidersJack
