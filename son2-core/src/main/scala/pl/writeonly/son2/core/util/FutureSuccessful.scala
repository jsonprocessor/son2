package pl.writeonly.son2.core.util

import org.scalactic.{Bad, Good, Or}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

object FutureSuccessful {
  def optFuture[A](value: Option[Future[A]])(
      implicit ec: ExecutionContext): Future[Option[A]] = value match {
    case Some(f: Future[A]) => for (a <- f) yield Option(a)
    case None               => Future.successful(None)
  }

  def eitherFuture[A, B](value: Either[A, Future[B]])(
      implicit ec: ExecutionContext): Future[Either[A, B]] =
    value match {
      case Right(f: Future[B]) => for (a <- f) yield Right(a)
      case Left(a: A)          => Future.successful(Left(a))
    }

  def tryFuture[A](value: Try[Future[A]])(
      implicit ec: ExecutionContext): Future[Try[A]] = value match {
    case Success(f: Future[A]) => for (a <- f) yield Success(a)
    case Failure(a)            => Future.successful(Failure(a))
  }

  def orFuture[A, B](value: Future[A] Or B)(
      implicit ec: ExecutionContext): Future[A Or B] = value match {
    case Good(f: Future[A]) => for (a <- f) yield Good(a)
    case Bad(a)             => Future.successful(Bad(a))
  }

  implicit class FutureOpt[A](opt: Option[Future[A]])(
      implicit ec: ExecutionContext) {
    def optFuture: Future[Option[A]] = FutureSuccessful.optFuture(opt)(ec)
  }

  implicit class FutureEither[A, B](value: Either[A, Future[B]])(
      implicit ec: ExecutionContext) {
    def eitherFuture: Future[Either[A, B]] =
      FutureSuccessful.eitherFuture(value)(ec)
  }

  implicit class FutureTry[A](value: Try[Future[A]])(
      implicit ec: ExecutionContext) {
    def tryFuture: Future[Try[A]] = FutureSuccessful.tryFuture(value)(ec)
  }

  implicit class FutureOr[A, B](value: Future[A] Or B)(
      implicit ec: ExecutionContext) {
    def orFuture: Future[A Or B] = FutureSuccessful.orFuture(value)(ec)
  }

}
