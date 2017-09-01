package pl.writeonly.son2.core.converters

import pl.writeonly.son2.core.config.Config

abstract class Converter(val config: Config) {

  def convert(s: String): String

  def comment(content: String): String

}
