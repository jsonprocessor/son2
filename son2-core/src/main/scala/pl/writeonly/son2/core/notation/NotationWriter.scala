package pl.writeonly.son2.core.notation

import org.scalactic.{Bad, Good, Or}
import pl.writeonly.son2.core.config.WConfig

abstract class NotationWriter(val config: WConfig) {

  def apply(value: Any Or String): String = value match {
    case Good(v) => write(v)
    case Bad(s) => comment(s)
  }

  def write(value: Any): String = config.style match {
    case true => writePretty(value)
    case false => writeRaw(value)
  }

  def comment(content: String) = content

  def writePretty(value: Any): String //= value.toString()

  def writeRaw(value: Any): String //= value.toString()
}
