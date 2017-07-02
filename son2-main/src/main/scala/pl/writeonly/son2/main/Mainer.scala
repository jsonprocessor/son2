package pl.writeonly.son2.main

import pl.writeonly.son2.core.formats.matchers.ChainCreator
import pl.writeonly.son2.core.glue.{Config, ProviderCreator, ProviderCreator$}
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.core.ConfigJack
import pl.writeonly.son2.jack.glue.{ChainCreatorJack, ProviderCreatorJack}
import pl.writeonly.son2.path.core.ConfigPath
import pl.writeonly.son2.path.creators.PartialCreatorPath
import pl.writeonly.son2.path.glue.ChainCreatorPath

class Mainer(params: Params, args: Array[String]) {
  val length = args.length

  def either = option match {
    case Right(provider) => new Piper(params, provider).right(args.slice(1, length))
    case Left(format) => new Resourcer(params).left(format)
  }

  def option: Either[Option[String], Provider] = length match {
    case 0 => Left(Option.empty)
    case _ => provider(args(0).toLowerCase)
    //    case _ => MatcherFormatProvider.either(new Parser().apply(args(0)))
  }

  def provider(s: String): Either[Option[String], Provider] = s match {
    case s if new PartialCreatorPath().isDefinedAt(s) => Right(p(ConfigPath(i = s)))
    case s => ProviderCreatorJack.either(ConfigJack(o = s))
  }

  def p(c: Config) = ProviderCreator.provider(c, path(c), jack(c))

  def path(c: Config): ChainCreator = new ChainCreatorPath(c.p)

  def jack(c: Config): ChainCreator = new ChainCreatorJack(c.p)
}
