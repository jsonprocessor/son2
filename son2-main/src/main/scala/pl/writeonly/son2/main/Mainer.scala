package pl.writeonly.son2.main

import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.core.ConfigJack
import pl.writeonly.son2.jack.glue.MatcherFormatProviderJack

class Mainer(params: Params, args: Array[String]) {
  val length = args.length

  def either = option match {
    case Right(provider) => new Piper(params, ConfigJack(o = o), provider).right(args.slice(1, length))
    case Left(format) => new Resourcer(params).left(format)
  }

  def option: Either[Option[String], Provider] = length match {
    case 0 => Left(Option.empty)
    case _ => MatcherFormatProviderJack.either(ConfigJack(o = o))
    //    case _ => MatcherFormatProvider.either(new Parser().apply(args(0)))
  }

  def o = args(0).toLowerCase
}
