package pl.writeonly.son2.gson.glue

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.glue.CreatorProviderOr

class ChainNotationConfigJson  extends CreatorProviderOr(new ChainNotationConfigJack().get, new ChainNotationRWTJack()) {
  override def configOpt(s: String): Option[Config] = chainNotationCreator.configOpt(s) match {
    case c: Some[Config] => c
//    case None => new ChainReaderJack().configOpt(s)
  }
}

