package pl.writeonly.son2.path.core

import pl.writeonly.son2.apis.config.Provider

object ProvidersPath {
  val GSON = Provider('gson)
  val JACKSON = Provider('jackson)
  val JACKSON_TYPED = Provider('jackson_typed)
  val JETTISON = Provider('jettison)
  val ORG = Provider('org)
  val SMART = Provider('smart)
  val STRICT = Provider('strict)
  val TAPESTRY = Provider('tapestry)

  val PATH = '$

  val ALL =
    List(GSON, JACKSON, JACKSON_TYPED, JETTISON, ORG, SMART, STRICT, TAPESTRY)
}
