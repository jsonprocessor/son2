package pl.writeonly.scallions.apis.config

trait HasConfigOpt {
  def configOpt(s: String): Option[RWTConfig]
}
