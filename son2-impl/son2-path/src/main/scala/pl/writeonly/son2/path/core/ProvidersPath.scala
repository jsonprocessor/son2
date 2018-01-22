package pl.writeonly.son2.path.core

object ProvidersPath {
  val GSON = 'gson
  val JACKSON = 'jackson
  val JACKSON_TYPED = 'jackson_typed
  val JETTISON = 'jettison
  val ORG = 'org
  val SMART = 'smart
  val STRICT = 'strict
  val TAPESTRY = 'tapestry

  val PATH = '$

  val ALL =
    List(GSON, JACKSON, JACKSON_TYPED, JETTISON, ORG, SMART, STRICT, TAPESTRY)
}
