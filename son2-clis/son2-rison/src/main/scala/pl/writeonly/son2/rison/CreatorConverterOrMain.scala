package pl.writeonly.son2.rison


import pl.writeonly.son2.apis.config.RWTConfig

class CreatorConverterOrMain
  extends CreatorConverterOr(null, null) {
  override def configOpt(s: String): Option[RWTConfig] = ConfigOpt.configOpt(s)

}
