package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.config.Config

abstract class Provider1(config: Config, a : Any) extends Provider(config) {

  def convert(content: String): String

  def comment(content: String): String

}
