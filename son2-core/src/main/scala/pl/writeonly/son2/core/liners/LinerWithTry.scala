package pl.writeonly.son2.core.liners

import com.typesafe.scalalogging.LazyLogging
import pl.writeonly.son2.core.converters.Converter

import scala.util.{Failure, Success, Try}
import scala.util.control.Exception._

class LinerWithTry(converter: Converter)
    extends Liner(converter)
    with LazyLogging {

  def apply(line: String): String = withTry(line) match {
    case Success(result) => result
    case Failure(e) => {
      logger.error("{} {}", converter, line)
      logger.error("", e)
      e.getMessage + "\n"
    }
  }

  def withTry(line: String): Try[String] =
    catching(classOf[Exception]).withTry(convert(line))

}
