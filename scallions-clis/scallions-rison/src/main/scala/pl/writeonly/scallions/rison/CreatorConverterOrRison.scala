package pl.writeonly.scallions.rison

import pl.writeonly.scallions.apis.config.RWTConfig
import pl.writeonly.scallions.funs.glue.CreatorConverterOr

class CreatorConverterOrRison extends CreatorConverterOr(null, null) {
  override def configOpt(s: String): Option[RWTConfig] =
    new ConfigOptRison().configOpt(s)

}
