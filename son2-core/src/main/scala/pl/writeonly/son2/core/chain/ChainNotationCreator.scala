package pl.writeonly.son2.core.chain

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.notation.{NotationPair, NotationReader, NotationTranslator, NotationWriter}
import pl.writeonly.son2.core.providers.{Provider, Provider1, Provider2}

class ChainNotationCreator(chain: PartialFunction[String, NotationPair]) extends ConfigLift {

  def lift(s: String): Option[Provider] = configOpt(s).map(provider)

  def configOpt(s: String): Option[Config] = chain
    .lift(s)
    .map(t => t.c)
    .map(f => f(s))

  def provider(c: Config):Provider = translator(c)
    .map(t => new Provider2(c, t, t))
    .getOrElse(new Provider2(c, input(c), output(c)))


  private def translator(c:Config): Option[NotationTranslator] = chain
    .lift(actionAndFormat(c)).map(f => f.t)

  private def actionAndFormat(c:Config):String = c
    .translate
    .actionAndFormat

  private def input(c: Config): NotationReader = chain.lift(c.i).map(f => f.r).get

  private def output(c: Config): NotationWriter = chain.lift(c.o).map(f => f.w).get
}
