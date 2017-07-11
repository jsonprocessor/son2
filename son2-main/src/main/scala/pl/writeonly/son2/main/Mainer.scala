package pl.writeonly.son2.main

import pl.writeonly.son2.core.chain.ChainNotationPair
import pl.writeonly.son2.core.glue.ProviderCreator
import pl.writeonly.son2.core.notation.{Config, NotationPair, NotationReader, NotationWriter}
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.chain.{ChainNotationPairJack, ChainReaderJack}
import pl.writeonly.son2.jack.core.ConfigJack
import pl.writeonly.son2.jack.glue.ProviderCreatorJack
import pl.writeonly.son2.path.chain.ChainNotationPairPath
import pl.writeonly.son2.path.core.ConfigPath
import pl.writeonly.son2.path.creators.PartialCreatorPath

class Mainer(params: Params, args: Array[String]) {
  val length = args.length

  def either = option match {
    case Right(provider) => new Piper(params, provider).right(args.slice(1, length))
    case Left(format) => new Resourcer(params).left(format)
  }

  def option: Either[Option[String], Provider] = length match {
    case 0 => Left(Option.empty)
    case _ => provider(args(0).toLowerCase)
  }

  def provider(s: String): Either[Option[String], Provider] = s match {
    case s if new PartialCreatorPath().isDefinedAt(s) => Right(p(ConfigPath(i = s)))
    case s => ProviderCreatorJack.either(ConfigJack(o = s))
  }

  def provider2(s: String): Either[Option[String], Provider] = chain(s)
    .map(p => Right(p))
    .getOrElse(Left(Option(s)))

  def chain(s:String) : Option[Provider] = chain(false)
    .lift(s).map(t => t.c)
    .map(f => f(s))
    .map(provider)

  def chain(p : Boolean) : PartialFunction[String, NotationPair] = (
    new ChainNotationPairPath(p).get
      orElse
      new ChainNotationPairJack(p).get
    )

  def provider(c : Config) = new Provider(c, input(c), output(c))

  def input(c :Config):NotationReader = chain(c.p).lift(c.i).map(f => f.r).get

  def output(c :Config):NotationWriter = chain(c.p).lift(c.o).map(f => f.w).get

  def p(c: Config) = ProviderCreator.provider(c, path(c), jack(c))

  def path(c: Config): ChainNotationPair = new ChainNotationPairPath(c.p)

  def jack(c: Config): ChainNotationPair = new ChainNotationPairJack(c.p)

  def reader = new ChainReaderJack()

}
