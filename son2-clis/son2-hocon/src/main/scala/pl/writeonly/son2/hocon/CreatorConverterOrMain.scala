package pl.writeonly.son2.hocon

import pl.writeonly.son2.apis.config.RWTConfig
import pl.writeonly.son2.funs.glue.CreatorConverterOr

class CreatorConverterOrMain extends CreatorConverterOr(null, null) {
  override def configOpt(s: String): Option[RWTConfig] =
    ConfigOptHocon.configOpt(s)

}
