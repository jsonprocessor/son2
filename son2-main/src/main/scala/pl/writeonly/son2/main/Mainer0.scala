package pl.writeonly.son2.main

import pl.writeonly.son2.core.glue.{Params, Piper}
import pl.writeonly.son2.core.providers.Provider2

abstract class Mainer0(params: Params, args: Array[String]) {
  val length = args.length

  def either = option match {
    case Right(provider) => new Piper(params, provider).right(args.slice(1, length))
    case Left(format) => new Resourcer(params).left(format)
  }

  def option: Either[Option[String], Provider2] = length match {
    case 0 => Left(Option.empty)
    case _ => provider(args(0).toLowerCase)
  }

  def provider(s: String): Either[Option[String], Provider2]

}
