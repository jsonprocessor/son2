package pl.writeonly.son2.apis.converters

import pl.writeonly.son2.apis.config.RWTConfig

abstract class Converter(val config: RWTConfig) {

  def convert(s: String): String

  def comment(content: String): String

}
