package pl.writeonly.son2.core

import pl.writeonly.son2.util.AppLogging

import scala.util.{Failure, Success, Try}

import scala.util.control.Exception._

class Son2 extends AppLogging {

  def convert(jsonString: String) = jsonString + "\n"

  def comment(jsonString: String) = jsonString + "\n"

  def apply(jsonString:String) = applyOpt(jsonString)

  def applyOpt(jsonString: String): String = {
    catching(classOf[Exception])
      .opt(convert(jsonString))
      .getOrElse(comment(jsonString))
  }


  def applyEither(jsonString: String): String = {
    val result: Either[Throwable, String] = catching(classOf[ArithmeticException])
      .either(convert(jsonString))
    result match {
      case Right(yaml) => yaml
      case Left(exception) => {
        logger.error(jsonString, exception)
        comment(jsonString)
      }
    }
  }

  def applyTry(jsonString: String): String = {
    Try(convert(jsonString)) match {
      case Success(yaml) => yaml
      case Failure(exception) => {
        logger.error(jsonString, exception)
        comment(jsonString)
      }
    }
  }

}
