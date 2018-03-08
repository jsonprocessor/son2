package pl.writeonly.son2.core.converters

import pl.writeonly.son2.core.config.RWTConfig

abstract class Converter(val config: RWTConfig) {

  def convert(s: String): String

  def comment(content: String): String

}
