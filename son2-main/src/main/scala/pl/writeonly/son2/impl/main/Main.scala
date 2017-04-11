package pl.writeonly.son2.impl.main

import pl.writeonly.son2.core.core.Config
import pl.writeonly.son2.core.formats.FormatProvider
import pl.writeonly.son2.core.providers._
import pl.writeonly.son2.core.util.AppLogging


object Main extends AppLogging {

  provider match {
    case Right(provider) => right(new Piper(provider))
    case Left(format) => left(format)
  }

  def provider: Either[Option[String], Provider] = length match {
    case 0 => Left(Option.empty)
    case _ => FormatProvider.opt(Config(o = o))
  }

  def length = args.length

  def o = args(0).toLowerCase

  def right(piper: Piper) = length match {
    case 1 => piper.convertStream();
    case 2 => piper.convertFile(args(1));
    case _ => piper.convertFile(args(1), args(2));
  }

  def left(resource: Option[String]) = new Piper(new ProviderImpl).convertResource(validOpt(resource))

  def validOpt(resource: Option[String]) = valid(resource.getOrElse(Resources.README))

  def valid(resource: String) = Resources.ALL
    .find(it => it.toUpperCase.startsWith(resource))
    .getOrElse({
      Resources.UNKNOWN_FORMAT + resource
      Resources.README
    })

}
