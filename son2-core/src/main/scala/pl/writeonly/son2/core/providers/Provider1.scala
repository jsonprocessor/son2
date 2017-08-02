package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.notation.NotationConverter

abstract class Provider1(config: Config, nc: NotationConverter) extends Provider(config) {

  def convert(s: String) = nc.write(nc.apply(s))

  def comment(s: String): String

}
