package pl.writeonly.scallions.text.core

import pl.writeonly.scallions.apis.config.Action

object Actions {
  val ESCAPE = Action('escape)
  val UNESCAPE = Action('unescape)

  val ALL = List(ESCAPE, UNESCAPE)
}
