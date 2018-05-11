package pl.writeonly.scallions.apis.notation

import org.scalactic.{Bad, Good, Or}
import pl.writeonly.scallions.apis.config.WStyle.{WPretty, WRaw}
import pl.writeonly.scallions.apis.config._

abstract class NotationWriter(meta: Meta, val config: WConfig)
    extends NotationMeta(meta) {

  def apply(value: Value Or String): String = value match {
    case Good(v) => write(v)
    case Bad(s)  => comment(s)
  }

  def write(value: Value): String = config.style match {
    case WPretty => writePretty(value)
    case WRaw    => writeRaw(value)
  }

  def comment(content: String): String = content

  def writePretty(value: Value): String //= value.toString

  def writeRaw(value: Value): String //= value.toString

  override def toString: String = (this, config).toString
}
