package pl.writeonly.son2.core.liners

import pl.writeonly.son2.core.converters.Converter

import scala.util.control.Exception._

class LinerOpt(provider: Converter) extends Liner(provider) {

  def apply(line: String): String = opt(line).getOrElse(comment(line))

  def opt(line: String): Option[String] =
    catching(classOf[Exception])
      .opt(convert(line))
}
