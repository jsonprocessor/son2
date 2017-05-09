package pl.writeonly.son2.impl.main

import pl.writeonly.son2.core.formats.MatcherFormatProvider
import pl.writeonly.son2.core.main.Parser
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.core.util.AppLazyLogging


object Jack extends AppLazyLogging {


  def provider: Either[Option[String], Provider] = length match {
    case 0 => Left(Option.empty)
    case _ => MatcherFormatProvider.either(new Parser().apply(args(0)))
  }

  def length = args.length

}
