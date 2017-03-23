package pl.writeonly.son2.core.liners

import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.util.AppLogging

import scala.util.control.Exception._
import scala.util.{Failure, Success, Try}

class LinerTry(provider : Provider) extends Liner(provider) {

  def apply(s: String): String = {
    Try(convert(s)) match {
      case Success(yaml) => yaml
      case Failure(exception) => {
        logger.error(s, exception)
        comment(s)
      }
    }
  }

}
