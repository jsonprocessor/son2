package pl.writeonly.son2.core.util

import org.skyscreamer.jsonassert.{JSONCompare, JSONCompareMode, JSONCompareResult}

import scala.util.control.Exception.catching

object JsonComparator {
  def apply(expected: String, actual: String, mode: JSONCompareMode): String
  = either(expected, actual, mode ) match {
      case Right(result) => result.toString
      case Left(exception) => exception.getMessage
  }

  def either(expected: String, actual: String, mode: JSONCompareMode): Either[Throwable, JSONCompareResult]
  = catching(classOf[Exception]).either(JSONCompare.compareJSON(expected, actual, mode))
}
