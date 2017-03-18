package pl.writeonly.son2.core

import pl.writeonly.son2.util.AppLogging

import scala.util.{Failure, Success, Try}

import scala.util.control.Exception._

class Son2 extends AppLogging {

  def applyOpt(jsonString: String): String = map(jsonString) { s =>
    val result = catching(classOf[RuntimeException]) opt {
      apply(jsonString)
    }
    result.getOrElse(comment(jsonString))
  }

  def applyEither(jsonString: String): String = map(jsonString) { s =>
    val result: Either[Throwable, String] = catching(classOf[ArithmeticException]) either {
      apply(jsonString)
    }
    result match {
      case Right(yaml) => yaml
      case Left(exception) => {
        logger.error(jsonString, exception)
        comment(jsonString)
      }
    }
  }

  def applyTry(jsonString: String): String = map(jsonString) { s =>
    Try(apply(jsonString)) match {
      case Success(yaml) => yaml
      case Failure(exception) => {
        logger.error(jsonString, exception)
        comment(jsonString)
      }
    }
  }

  def map(jsonString: String)(f: String => String): String = {
    Option(jsonString)
      .map(f)
      .getOrElse(null)
  }

  def apply(jsonString: String) = jsonString

  def comment(jsonString:String) = jsonString



}
