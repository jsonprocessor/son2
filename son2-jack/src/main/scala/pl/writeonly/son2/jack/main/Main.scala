package pl.writeonly.son2.jack.main

import pl.writeonly.son2.core.core.Config
import pl.writeonly.son2.core.formats.MatcherFormatProvider
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.core.util.AppLazyLogging


object Main extends AppLazyLogging {


  def provider: Either[Option[String], Provider] = length match {
    case 0 => Left(Option.empty)
    case _ => MatcherFormatProvider.either(Config(o = args(0)))
  }

  def length = args.length

}
