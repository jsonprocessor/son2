package pl.writeonly.scallions.json.glue

import pl.writeonly.scallions.apis.config.RWTConfig
import pl.writeonly.scallions.funs.glue.CreatorConverterOr

class CreatorConverterOrJson
    extends CreatorConverterOr(
      new ChainNotationConfigJson().get,
      new ChainNotationRWTJson()
    ) {
  override def configOpt(s: String): Option[RWTConfig] =
    chainNotationCreator.configOpt(s)
}
