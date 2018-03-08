package pl.writeonly.son2.core.config

trait HasConfigOpt {
  def configOpt(s: String): Option[RWTConfig]
}
