package pl.writeonly.scallions.jack.glue

import pl.writeonly.scallions.jack.chain.ChainReaderJack
import pl.writeonly.scallions.apis.config.RWTConfig
import pl.writeonly.scallions.funs.glue.CreatorConverterOr

class CreatorConverterOrJack
    extends CreatorConverterOr(
      new ChainNotationConfigJack().get,
      new ChainNotationRWTJack()
    ) {

  override def configOpt(s: String): Option[RWTConfig] =
    chainNotationCreator.configOpt(s) orElse new ChainReaderJack().configOpt(s)
}
