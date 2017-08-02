package pl.writeonly.son2.text.glue

import org.scalactic.{Bad, ErrorMessage, Good, Or}
import pl.writeonly.son2.core.chain.ChainNotationCreator
import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.glue.CreatorProviderOr
import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.text.chain.ChainNotationPairText

class CreatorProviderOrText extends CreatorProviderOr {

  override def provider(s: String): Provider Or ErrorMessage = configOpt(s)
    .map(c => chainNotationCreator.provider(c))
    .map(p => Good(p))
    .getOrElse(Bad(s))

  def configOpt(s: String): Option[Config] = chainNotationCreator.configOpt(s) match {
    case c: Some[Config] => c
  }

  val chainNotationCreator = new ChainNotationCreator(
      new ChainNotationPairText().get
  )

}
