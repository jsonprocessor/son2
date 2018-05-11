package pl.writeonly.scallions.funs.liners

import com.typesafe.scalalogging.LazyLogging
import pl.writeonly.scallions.apis.converters.Converter

import scala.util.control.Exception._
import scala.util.{Failure, Success, Try}

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
