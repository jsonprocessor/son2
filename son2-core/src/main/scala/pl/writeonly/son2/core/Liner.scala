package pl.writeonly.son2.core

import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.util.AppLogging

import scala.util.{Failure, Success, Try}
import scala.util.control.Exception._

class Liner(provider : Provider) extends AppLogging {

  def convertln(jsonString: String) = provider.convert(jsonString) + "\n"

  def commentln(jsonString: String) = provider.comment(jsonString)  + "\n"

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
