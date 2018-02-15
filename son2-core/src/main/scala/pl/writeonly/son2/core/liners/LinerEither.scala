package pl.writeonly.son2.core.liners

import com.typesafe.scalalogging.LazyLogging
import pl.writeonly.son2.core.converters.Converter

import scala.util.control.Exception._

class LinerEither(converter: Converter)
    extends Liner(converter)
    with LazyLogging {

  def apply(line: String): String = either(line) match {
    case Right(result) => result
    case Left(e) => {
      logger.error("{} {}", converter, line)
      logger.error("", e)
      e.getMessage + "\n"
    }
  }

  def either(line: String): Either[Throwable, String] =
    catching(classOf[Exception]).either(convert(line))

}
