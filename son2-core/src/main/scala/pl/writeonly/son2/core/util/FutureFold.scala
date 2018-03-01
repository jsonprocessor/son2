package pl.writeonly.son2.core.util

import org.scalactic.Or

import scala.concurrent.{ExecutionContext, Future}
import scala.util.Try

object FutureFold {
  def optFuture[A](value: Option[Future[A]])(
      implicit ec: ExecutionContext): Future[A] =
    value.fold(Future.failed[A](new IllegalStateException()))(identity)

  def eitherFuture[A, B](value: Either[A, Future[B]])(
      implicit ec: ExecutionContext): Future[B] =
    value.fold(f => Future.failed[B](toThrowable(f)), identity)

  def tryFuture[A](value: Try[Future[A]])(
      implicit ec: ExecutionContext): Future[A] =
    value.fold(f => Future.failed(f), identity)

  def orFuture[A, B](value: Future[A] Or B)(
      implicit ec: ExecutionContext): Future[A] =
    value.fold(identity, f => Future.failed(toThrowable(f)))

  private def toThrowable(a: Any): Throwable = a match {
    case f: Throwable => f
    case _            => new IllegalStateException("" + a)
  }

  private def identity[A](a: A) = a

  implicit class FutureOpt[A](opt: Option[Future[A]])(
      implicit ec: ExecutionContext) {
    def optFuture: Future[A] = FutureFold.optFuture(opt)(ec)
  }

  implicit class FutureEither[A, B](value: Either[A, Future[B]])(
      implicit ec: ExecutionContext) {
    def eitherFuture: Future[B] = FutureFold.eitherFuture(value)(ec)
  }

  implicit class FutureTry[A](value: Try[Future[A]])(
      implicit ec: ExecutionContext) {
    def tryFuture: Future[A] = FutureFold.tryFuture(value)(ec)
  }

  implicit class FutureOr[A, B](value: Future[A] Or B)(
      implicit ec: ExecutionContext) {
    def orFuture: Future[A] = FutureFold.orFuture(value)(ec)
  }

}
