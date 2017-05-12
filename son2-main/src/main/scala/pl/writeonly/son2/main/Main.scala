package pl.writeonly.son2.main

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.formats.MatcherFormatProvider
import pl.writeonly.son2.jack.providers._
import pl.writeonly.son2.jack.util.AppLazyLogging

object Main extends AppLazyLogging {
  new Main(Params(System.in, System.out), args).either
}

class Main(params: Params, args : Array[String]) {
  val length = args.length

  def either = option match {
    case Right(provider) => new Piper(params, Config(o=o), provider).right(args.slice(1, length))
    case Left(format) => new Resourcer(params).left(format)
  }

  def option: Either[Option[String], Provider] = length match {
    case 0 => Left(Option.empty)
    case _ => MatcherFormatProvider.either(Config(o=o))
  }

  def o = args(0).toLowerCase
}

