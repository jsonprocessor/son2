package pl.writeonly.son2.core.liners

import pl.writeonly.son2.core.providers.{Provider, Provider2}

import scala.util.control.Exception._

class LinerOpt(provider: Provider) extends Liner(provider) {

  def apply(line: String): String = {
    catching(classOf[Exception])
      .opt(convert(line))
      .getOrElse(comment(line))
  }
}
