package pl.writeonly.son2.jack.core

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.glue.CreatorProviderOr
import pl.writeonly.son2.jack.chain.{ChainNotationPairJack, ChainReaderJack}

class CreatorProviderOrJack extends CreatorProviderOr(new ChainNotationPairJack(true).get) {

  override def configOpt(s: String): Option[Config] = chainNotationCreator.configOpt(s) match {
    case c: Some[Config] => c
    case None => new ChainReaderJack().configOpt(s)
  }
}
