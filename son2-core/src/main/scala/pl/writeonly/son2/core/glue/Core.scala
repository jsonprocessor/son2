package pl.writeonly.son2.core.glue

import com.google.common.base.Preconditions
import pl.writeonly.son2.core.providers.{Provider, Provider2}

abstract class Core(params: Params, args: Array[String]) {
  val length = args.length

  def either = option match {
    case Right(provider) => new Piper(params, provider).right(args.slice(1, length))
    case Left(format) => left(params, format)
  }

  def option: Either[Option[String], Provider] = length match {
    case 0 => Left(Option.empty)
    case _ => provider(args(0).toLowerCase)
  }

  def provider(s: String): Either[Option[String], Provider]

  def left(params: Params, format: Option[String]) : Unit = Preconditions.checkState(false, format)

}
