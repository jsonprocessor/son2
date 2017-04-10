package pl.writeonly.son2.impl.main

import pl.writeonly.son2.core.core.Config
import pl.writeonly.son2.core.formats.FormatProvider
import pl.writeonly.son2.core.providers._
import pl.writeonly.son2.core.util.AppLogging

object Main extends AppLogging {

  def right(p:Provider) = {
    val piper = new Piper(p)
    args.length match {
      case 1 => piper.convertStream();
      case 2 => piper.convertFile(args(1));
      case _ => piper.convertFile(args(1), args(2));
    }}

  def left() = {
    val main = new Piper(new ProviderImpl)
    main.convertResource("README.md")
  }

  val provider : Either[String, Provider] = args.length match {
    case 0 => Left(null)
    case _ => FormatProvider.opt(Config(o = args(0).toLowerCase))
  }

  provider match {
    case Right(x) => right(x)
    case Left(x) => left()
  }
}
