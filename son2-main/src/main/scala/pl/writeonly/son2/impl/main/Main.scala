package pl.writeonly.son2.impl.main

import pl.writeonly.son2.jack.core.Config
import pl.writeonly.son2.jack.formats.MatcherFormatProvider
import pl.writeonly.son2.jack.providers._
import pl.writeonly.son2.jack.util.AppLazyLogging

object Main extends AppLazyLogging {

  provider match {
    case Right(provider) => right(new Piper(provider))
    case Left(format) => new ResourceManager().left(format)
  }

  def provider: Either[Option[String], Provider] = length match {
    case 0 => Left(Option.empty)
    case _ => MatcherFormatProvider.either(Config(o = o))
  }

  def length = args.length

  def o = args(0).toLowerCase

  def right(piper: Piper) = length match {
    case 1 => piper.convertStream();
    case 2 => piper.convertFile(args(1));
    case _ => piper.convertFile(args(1), args(2));
  }

}
