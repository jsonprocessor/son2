package pl.writeonly.scallions.hocon

import pl.writeonly.scallions.apis.config.RWTConfig
import pl.writeonly.scallions.funs.glue.CreatorConverterOr

class CreatorConverterOrHocon extends CreatorConverterOr(null, null) {
  override def configOpt(s: String): Option[RWTConfig] =
    new ConfigOptHocon().configOpt(s)

}
