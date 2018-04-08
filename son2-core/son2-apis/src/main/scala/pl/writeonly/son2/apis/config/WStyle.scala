package pl.writeonly.son2.apis.config

import com.fasterxml.jackson.annotation.JsonCreator

sealed case class WStyle(it: Boolean) extends PartialFunction[Boolean, WStyle] {
  override def isDefinedAt(x: Boolean): Boolean = x == it

  override def apply(v1: Boolean): WStyle = this

  override def toString: String = s"WStyle($it)"
}

object WRaw extends WStyle(false)

object WPretty extends WStyle(true)

case object WStyle {
  type T = Boolean => WStyle

  def get: T = WRaw orElse WPretty

  @JsonCreator
  def create(b: Boolean): WStyle = get.apply(b)
}
