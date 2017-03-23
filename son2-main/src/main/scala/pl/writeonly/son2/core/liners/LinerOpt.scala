package pl.writeonly.son2.core.liners

import pl.writeonly.son2.core.providers.Provider

import scala.util.control.Exception._

class LinerOpt(provider : Provider) extends Liner(provider) {

  def apply(s: String): String = {
    catching(classOf[Exception])
      .opt(convert(s))
      .getOrElse(comment(s))
  }
}
