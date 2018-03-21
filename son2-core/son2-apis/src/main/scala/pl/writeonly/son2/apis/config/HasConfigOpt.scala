package pl.writeonly.son2.apis.config

trait HasConfigOpt {
  def configOpt(s: String): Option[RWTConfig]
}
