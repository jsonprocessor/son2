package pl.writeonly.son2.json.glue

import pl.writeonly.son2.core.config.RWTConfig
import pl.writeonly.son2.core.glue.CreatorConverterOr

class CreatorConverterOrJson
    extends CreatorConverterOr(new ChainNotationConfigJson().get,
                               new ChainNotationRWTJson()) {
  override def configOpt(s: String): Option[RWTConfig] =
    chainNotationCreator.configOpt(s) match {
      case c: Some[RWTConfig] => c
      case _                  => throw new IllegalArgumentException
    }
}
