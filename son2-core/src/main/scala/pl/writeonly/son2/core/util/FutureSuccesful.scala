package pl.writeonly.son2.core.util

import org.scalactic.{Bad, Good, Or}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

object FutureSuccesful {

  def opt[A](value: Future[A])(
      implicit ec: ExecutionContext): Future[Option[A]] =
    value.transformWith({
      case Success(s) => Future.successful(Option(s))
      case Failure(_) => Future.successful(None)
    })

  def either[A](value: Future[A])(
      implicit ec: ExecutionContext): Future[Either[Throwable, A]] =
    value.transformWith({
      case Success(s) => Future.successful(Right(s))
      case Failure(t) => Future.successful(Left(t))
    })

  def tryWith[A](value: Future[A])(
      implicit ec: ExecutionContext): Future[Try[A]] =
    value.transformWith(Future.successful)

  def or[A](value: Future[A])(
      implicit ec: ExecutionContext): Future[A Or Throwable] =
    value.transformWith({
      case Success(s) => Future.successful(Good(s))
      case Failure(t) => Future.successful(Bad(t))
    })

  implicit class FutureSuccessful[A](value: Future[A])(
      implicit ec: ExecutionContext) {
    def opt: Future[Option[A]] = FutureSuccesful.opt(value)(ec)
    def either: Future[Either[Throwable, A]] = FutureSuccesful.either(value)(ec)
    def tryWith: Future[Try[A]] = FutureSuccesful.tryWith(value)(ec)
    def or: Future[A Or Throwable] = FutureSuccesful.or(value)(ec)
  }

}
