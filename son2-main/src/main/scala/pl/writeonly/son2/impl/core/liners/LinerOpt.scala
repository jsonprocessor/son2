package pl.writeonly.son2.impl.core.liners

import pl.writeonly.son2.impl.core.providers.Provider

import scala.util.control.Exception._

class LinerOpt(provider : Provider) extends Liner(provider) {

  def apply(line: String): String = {
    catching(classOf[Exception])
      .opt(convert(line))
      .getOrElse(comment(line))
  }
}
