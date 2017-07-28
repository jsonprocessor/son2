package pl.writeonly.son2.core.chain

import pl.writeonly.son2.core.config.Config

trait ConfigLift {
  def configOpt(s: String): Option[Config]
}
