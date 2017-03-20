package pl.writeonly.son2.core

import pl.writeonly.son2.util.AppLogging

import scala.util.{Failure, Success, Try}

import scala.util.control.Exception._

class Son2 extends AppLogging {

  final def convertln(jsonString: String) = convert(jsonString) + "\n"

  final def commentln(jsonString: String) = comment(jsonString)  + "\n"

  protected def convert(jsonString: String) = jsonString

  protected def comment(jsonString: String) = jsonString


  def apply(jsonString:String) = applyOpt(jsonString)

  def applyOpt(jsonString: String): String = {
    catching(classOf[Exception])
      .opt(convertln(jsonString))
      .getOrElse(commentln(jsonString))
  }


  def applyEither(jsonString: String): String = {
    val result: Either[Throwable, String] = catching(classOf[ArithmeticException])
      .either(convertln(jsonString))
    result match {
      case Right(yaml) => yaml
      case Left(exception) => {
        logger.error(jsonString, exception)
        commentln(jsonString)
      }
    }
  }

  def applyTry(jsonString: String): String = {
    Try(convertln(jsonString)) match {
      case Success(yaml) => yaml
      case Failure(exception) => {
        logger.error(jsonString, exception)
        commentln(jsonString)
      }
    }
  }

}
