package pl.writeonly.scallions.jack.core

import pl.writeonly.scallions.apis.config.ProviderType

trait ProvidersJack {
  val JACKSON = ProviderType('jackson)
}

object ProvidersJack extends ProvidersJack
