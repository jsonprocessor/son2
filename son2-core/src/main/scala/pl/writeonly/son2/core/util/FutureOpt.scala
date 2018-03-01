package pl.writeonly.son2.core.util

import scala.concurrent.{ExecutionContext, Future}

class FutureOpt[A](opt: Option[Future[A]])(implicit ec: ExecutionContext) {
  def optFuture = FutureOpt.optFuture(opt)(ec)
}

object FutureOpt {
  def apply[A](opt: Option[Future[A]])(implicit ec: ExecutionContext) =
    new FutureOpt(opt)(ec)

  def optFuture[A](opt: Option[Future[A]])(
      implicit ec: ExecutionContext): Future[Option[A]] = opt match {
    case Some(f: Future[A]) => for (a <- f) yield Option(a)
    case None               => Future.successful(None)
  }
}

object FutureOptOps {
  implicit def toFutureOpt[A](opt: Option[Future[A]])(
      implicit ec: ExecutionContext) = FutureOpt(opt)(ec)
}
