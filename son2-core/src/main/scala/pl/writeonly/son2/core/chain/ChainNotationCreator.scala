package pl.writeonly.son2.core.chain

import pl.writeonly.son2.core.config.{Config, HasConfigOpt}
import pl.writeonly.son2.core.notation._
import pl.writeonly.son2.core.providers.{Provider, Provider1, Provider2}

class ChainNotationCreator(chain: PartialFunction[String, NotationPair])
  extends HasConfigOpt {

  def providerOpt(s: String): Option[Provider] = configOpt(s).map(provider)

  def configOpt(s: String): Option[Config] = chain
    .lift(s)
    .map(t => t.c(s))

  def provider(c: Config): Provider = translator(c)
    .map(t => new Provider1(c, t))
    .getOrElse(new Provider2(c, input(c), output(c)))

  private def translator(c: Config): Option[NotationTranslator] = chain
    .lift(actionAndFormat(c)).map(f => f.n.t)

  private def actionAndFormat(c: Config): String = c
    .translate
    .actionAndFormat

  private def input(c: Config): NotationReader = chain.lift(c.read.format.name).map(f => f.n.r).get

  private def output(c: Config): NotationWriter = chain.lift(c.write.format.name).map(f => f.n.w).get
}
