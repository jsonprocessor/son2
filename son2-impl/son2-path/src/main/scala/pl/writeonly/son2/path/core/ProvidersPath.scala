package pl.writeonly.son2.path.core

import pl.writeonly.son2.apis.config.ProviderType
import pl.writeonly.son2.jack.core.ProvidersJack

object ProvidersPath extends ProvidersJack {
  val GSON = ProviderType('gson)
  val JACKSON_TYPED = ProviderType('jackson_typed)
  val JETTISON = ProviderType('jettison)
  val ORG = ProviderType('org)
  val SMART = ProviderType('smart)
  val STRICT = ProviderType('strict)
  val TAPESTRY = ProviderType('tapestry)

  val PATH = '$

  val ALL =
    List(GSON, JACKSON, JACKSON_TYPED, JETTISON, ORG, SMART, STRICT, TAPESTRY)
}
