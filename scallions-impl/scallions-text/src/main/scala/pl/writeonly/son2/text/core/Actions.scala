package pl.writeonly.son2.text.core

import pl.writeonly.son2.apis.config.Action

object Actions {
  val ESCAPE = Action('escape)
  val UNESCAPE = Action('unescape)

  val ALL = List(ESCAPE, UNESCAPE)
}
