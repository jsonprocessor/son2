package pl.writeonly.son2.core.glue

import org.scalactic.{Bad, ErrorMessage, Good, Or}
import pl.writeonly.son2.core.chain.ChainNotationCreator
import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.notation.NotationPair
import pl.writeonly.son2.core.providers.Provider

abstract class CreatorProviderOr(chainNotationPair: PartialFunction[String, NotationPair]) {

  val chainNotationCreator = new ChainNotationCreator(chainNotationPair)

  def providerOr(s: String): Provider Or ErrorMessage = configOpt(s)
    .map(c => chainNotationCreator.provider(c))
    .map(p => Good(p))
    .getOrElse(Bad(s))

  def configOpt(s: String): Option[Config] = chainNotationCreator.configOpt(s)
}
