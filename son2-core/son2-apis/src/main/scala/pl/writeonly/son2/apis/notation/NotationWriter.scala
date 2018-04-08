package pl.writeonly.son2.apis.notation

import org.scalactic.{Bad, Good, Or}
import pl.writeonly.son2.apis.config._

abstract class NotationWriter(meta: MetaLike, val config: WConfig)
    extends NotationMeta(meta) {

  def apply(value: Any Or String): String = value match {
    case Good(v) => write(v)
    case Bad(s)  => comment(s)
  }

  def write(value: Any): String = config.style match {
    case WPretty => writePretty(value)
    case WRaw    => writeRaw(value)
  }

  def comment(content: String): String = content

  def writePretty(value: Any): String //= value.toString

  def writeRaw(value: Any): String //= value.toString

  override def toString: String = (this, config).toString
}
