package pl.writeonly.son2.path.core

object FormatsPath {
  val GSON = 'gson
  val JACKSON_NODE = 'node
  val JACKSON_TYPE = 'jackson
  val JETTISON = 'jettison
  val ORG = 'org
  val SMART = 'smart
  val STRICT = 'strict
  val TAPESTRY = 'tapestry

  val PATH = '$

  val ALL = List(GSON, JACKSON_NODE, JACKSON_TYPE, JETTISON, ORG, STRICT, TAPESTRY)
}
