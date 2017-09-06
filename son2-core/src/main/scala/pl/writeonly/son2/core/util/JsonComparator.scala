package pl.writeonly.son2.core.util

import org.skyscreamer.jsonassert.{JSONCompare, JSONCompareMode, JSONCompareResult}

import scala.util.control.Exception.catching

object JsonComparator {
  def apply(expectedStr: String, actualStr: String, mode: JSONCompareMode): Unit = {
    val result: Either[Throwable, JSONCompareResult] = catching(classOf[Exception])
      .either(JSONCompare.compareJSON(expectedStr, actualStr, mode))
    val value = result match {
      case Right(result) => result.toString
      case Left(exception) => exception.getMessage
    }
    return value
  }
}
