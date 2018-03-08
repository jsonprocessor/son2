package pl.writeonly.son2.jack.glue

import pl.writeonly.son2.core.config.RWTConfig
import pl.writeonly.son2.core.glue.CreatorConverterOr
import pl.writeonly.son2.jack.chain.ChainReaderJack

class CreatorConverterOrJack
    extends CreatorConverterOr(new ChainNotationConfigJack().get,
                               new ChainNotationRWTJack()) {

  override def configOpt(s: String): Option[RWTConfig] =
    chainNotationCreator.configOpt(s) orElse new ChainReaderJack().configOpt(s)
}
