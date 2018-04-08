package pl.writeonly.son2.apis.config

import com.fasterxml.jackson.annotation.JsonCreator

sealed case class RStyle(it: Boolean) extends PartialFunction[Boolean, RStyle] {
  override def isDefinedAt(x: Boolean): Boolean = x == it

  override def apply(v1: Boolean): RStyle = this

  override def toString: String = s"RStyle($it)"
}

object RStream extends RStyle(true)

object RAll extends RStyle(false)

case object RStyle {
  type T = Boolean => RStyle

  def get: T = RStream orElse RAll

  @JsonCreator
  def create(it: Boolean): RStyle = get.apply(it)
}
