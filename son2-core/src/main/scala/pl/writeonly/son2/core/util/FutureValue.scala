package pl.writeonly.son2.core.util

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

object FutureValue {
  def optFuture[A](value: Option[Future[A]])(
      implicit ec: ExecutionContext): Future[Option[A]] = value match {
    case Some(f: Future[A]) => for (a <- f) yield Option(a)
    case None               => Future.successful(None)
  }

  def eitherFuture[A](value: Either[Throwable, Future[A]])(
      implicit ec: ExecutionContext): Future[Either[Throwable, A]] =
    value match {
      case Right(f: Future[A]) => for (a <- f) yield Right(a)
      case Left(f: Throwable)  => Future.failed(f)
    }

  def tryFuture[A](value: Try[Future[A]])(
      implicit ec: ExecutionContext): Future[Try[A]] = value match {
    case Success(f: Future[A]) => for (a <- f) yield Success(a)
    case Failure(f: Throwable) => Future.failed(f)
  }

  implicit class FutureOpt[A](opt: Option[Future[A]])(
      implicit ec: ExecutionContext) {
    def optFuture = FutureValue.optFuture(opt)(ec)
  }

  implicit class FutureEither[A, B](value: Either[Throwable, Future[A]])(
      implicit ec: ExecutionContext) {
    def optFuture = FutureValue.eitherFuture(value)(ec)
  }

  implicit class FutureTry[A](value: Try[Future[A]])(
      implicit ec: ExecutionContext) {
    def optFuture = FutureValue.tryFuture(value)(ec)
  }

}
