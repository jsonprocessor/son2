package pl.writeonly.son2.core.liners

import pl.writeonly.son2.core.providers.Provider

import scala.util.control.Exception._

class LinerEither(provider : Provider) extends Liner(provider) {

  def apply(s: String): String = {
    val result: Either[Throwable, String] = catching(classOf[ArithmeticException])
      .either(convert(s))
    result match {
      case Right(result) => result
      case Left(exception) => {
        logger.error(s, exception)
        comment(s)
      }
    }
  }

}
