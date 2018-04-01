package pl.writeonly.son2.json.glue

import pl.writeonly.son2.apis.config.RWTConfig
import pl.writeonly.son2.funs.glue.CreatorConverterOr

class CreatorConverterOrJson
    extends CreatorConverterOr(
      new ChainNotationConfigJson().get,
      new ChainNotationRWTJson()
    ) {
  override def configOpt(s: String): Option[RWTConfig] =
    chainNotationCreator.configOpt(s) match {
      case c: Some[RWTConfig] => c
      case _                  => throw new IllegalArgumentException
    }
}
