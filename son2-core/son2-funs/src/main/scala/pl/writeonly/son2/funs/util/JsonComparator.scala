package pl.writeonly.son2.funs.util

import org.skyscreamer.jsonassert.{
  JSONCompare,
  JSONCompareMode,
  JSONCompareResult
}

import scala.util.control.Exception.catching

object JsonComparator {

  def apply(c: CompareConfig, expected: String, actual: String): String =
    apply(mode(c), expected: String, actual: String)

  def mode(c: CompareConfig): JSONCompareMode =
    JSONCompareMode.STRICT
      .withExtensible(c.extensible)
      .withStrictOrdering(c.strictOrder)

  def apply(mode: JSONCompareMode, expected: String, actual: String): String =
    either(mode, expected, actual) match {
      case Right(result)   => result.toString
      case Left(exception) => exception.getMessage
    }

  //FIXME Either[Throwable, JSONCompareResult] -> Try[JSONCompareResult]
  def either(mode: JSONCompareMode,
             expected: String,
             actual: String): Either[Throwable, JSONCompareResult] =
    catching(classOf[Exception])
      .either(JSONCompare.compareJSON(expected, actual, mode))
}

final case class CompareConfig(extensible: Boolean, strictOrder: Boolean)
