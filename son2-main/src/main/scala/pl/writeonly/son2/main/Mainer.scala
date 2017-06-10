package pl.writeonly.son2.main

import pl.writeonly.son2.core.glue.{Config, MatcherFormatProvider}
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.core.ConfigJack
import pl.writeonly.son2.jack.formats.creators.{CreatorFormatReader, CreatorFormatWriter}
import pl.writeonly.son2.jack.formats.matchers.MatcherFormatJack
import pl.writeonly.son2.jack.formats.predicates.PredicateFormatStartsWith
import pl.writeonly.son2.jack.glue.MatcherFormatProviderJack
import pl.writeonly.son2.path.formats.matchers.MatcherFormatPath
import pl.writeonly.son2.path.glue.ConfigPath

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

  def provider(s:String) : Either[Option[String], Provider] = s match {
    case s if new MatcherFormatPath().predicate(s) => Right(p(ConfigPath(s)))
    case s => MatcherFormatProviderJack.either(ConfigJack(o=s))
  }

  def p(c : Config) =  MatcherFormatProvider.provider(c, new MatcherFormatPath, new MatcherFormatJack(new PredicateFormatStartsWith, new CreatorFormatWriter(c)))

}
