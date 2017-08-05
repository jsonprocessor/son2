package pl.writeonly.son2.main

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.glue.CreatorProviderOr
import pl.writeonly.son2.jack.chain.{ChainNotationPairJack, ChainReaderJack}
import pl.writeonly.son2.path.chain.ChainNotationPairPath
import pl.writeonly.son2.text.chain.ChainNotationPairText

class CreatorProviderOrMain extends CreatorProviderOr(
  new ChainNotationPairPath(true).get
    orElse
    new ChainNotationPairJack(true).get
    orElse
    new ChainNotationPairText().get
) {

  override def configOpt(s: String): Option[Config] = chainNotationCreator.configOpt(s) match {
    case c: Some[Config] => c
    case None => new ChainReaderJack().configOpt(s)
  }
}
