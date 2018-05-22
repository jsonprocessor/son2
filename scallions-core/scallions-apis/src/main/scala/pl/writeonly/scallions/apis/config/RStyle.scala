package pl.writeonly.scallions.apis.config

import com.fasterxml.jackson.annotation.JsonCreator

sealed abstract class RStyle(it: Boolean)
    extends PartialFunction[Boolean, RStyle] {
  override def isDefinedAt(x: Boolean): Boolean = x == it

  override def apply(v1: Boolean): RStyle = this

  override def toString: String = s"RStyle($it)"
}

case object RStyle {
  type T = Boolean => RStyle

  def get: T = RStream orElse RAll

  def apply(it: Boolean): RStyle = get.apply(it)

  @JsonCreator
  def create(it: Boolean): RStyle = apply(it)

  case object RStream extends RStyle(true)

  case object RAll extends RStyle(false)

}
