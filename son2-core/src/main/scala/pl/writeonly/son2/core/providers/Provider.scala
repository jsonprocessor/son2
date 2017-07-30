package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.config.Config

abstract class Provider(val config: Config) {

  def convert(s: String): String

  def comment(content: String): String

}
