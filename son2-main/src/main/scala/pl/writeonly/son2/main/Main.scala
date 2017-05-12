package pl.writeonly.son2.main

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.formats.MatcherFormatProvider
import pl.writeonly.son2.jack.providers._
import pl.writeonly.son2.jack.util.AppLazyLogging

object Main extends AppLazyLogging {

  val length = args.length

  either

  def either = provider match {
    case Right(provider) => new Piper(System.in, System.out, provider).right(args.slice(1, length))
    case Left(format) => new Resourcer().left(format)
  }

  def provider: Either[Option[String], Provider] = length match {
    case 0 => Left(Option.empty)
    case _ => MatcherFormatProvider.either(Config(o = o))
  }

  def o = args(0).toLowerCase

}

