package pl.writeonly.scallions.apis.config

import com.fasterxml.jackson.annotation.JsonCreator

sealed abstract class WStyle(it: Boolean)
    extends PartialFunction[Boolean, WStyle] {
  override def isDefinedAt(x: Boolean): Boolean = x == it

  override def apply(v1: Boolean): WStyle = this

  override def toString: String = s"WStyle($it)"
}

case object WStyle {
  type T = Boolean => WStyle

  def get: T = WRaw orElse WPretty

  def apply(it: Boolean): WStyle = get.apply(it)

  @JsonCreator
  def create(it: Boolean): WStyle = apply(it)

  case object WRaw extends WStyle(false)

  case object WPretty extends WStyle(true)

}
