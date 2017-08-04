package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.config.Config
import pl.writeonly.son2.core.notation.NotationTranslator

abstract class Provider1(config: Config, f:String =>String) extends Provider(config) {

  def convert(s: String) = f(s)

  def comment(s: String): String

}
