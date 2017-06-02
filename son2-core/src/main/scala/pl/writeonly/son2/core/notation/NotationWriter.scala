package pl.writeonly.son2.core.notation

import org.scalactic.{Bad, Good, Or}

class NotationWriter(pretty: Boolean) {

  def apply(value : Any Or String) :String = value match {
    case Good(v) => write(v)
    case Bad(s) => comment(s)
  }

  def write(value: Any):String = pretty match {
    case true => writePretty(value)
    case false => writeRaw(value)
  }

  def writePretty(value: Any):String = value.toString()

  def writeRaw(value: Any):String = value.toString()

  def comment(s: String) = s
}
