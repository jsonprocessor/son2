package pl.writeonly.son2.jack.core

import org.scalactic.{Bad, ErrorMessage, Good, Or}
import pl.writeonly.son2.core.chain.ChainNotationCreator
import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.glue.CreatorProviderOr
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.jack.chain.{ChainNotationPairJack, ChainReaderJack}

class CreatorProviderOrJack extends CreatorProviderOr {

  override def provider(s: String): Provider Or ErrorMessage = configOpt(s)
    .map(c => chainNotationCreator.provider(c))
    .map(p => Good(p))
    .getOrElse(Bad(s))

  def configOpt(s: String): Option[Config] = chainNotationCreator.configOpt(s) match {
    case c: Some[Config] => c
    case None => new ChainReaderJack().configOpt(s)
  }

  val chainNotationCreator = new ChainNotationCreator(
      new ChainNotationPairJack(true).get
  )
}
