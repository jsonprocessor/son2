package pl.writeonly.son2.core.liners

import pl.writeonly.son2.core.converters.Converter

import scala.util.control.Exception._

class LinerEither(provider: Converter) extends Liner(provider) {

  def apply(line: String): String = {
    val result: Either[Throwable, String] = catching(classOf[Exception])
      .either(convert(line))
    result match {
      case Right(result) => result
      case Left(exception) => exception.getMessage + "\n"
    }
  }


}
