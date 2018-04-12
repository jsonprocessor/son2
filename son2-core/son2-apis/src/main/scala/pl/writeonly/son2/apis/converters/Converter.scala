package pl.writeonly.son2.apis.converters

import pl.writeonly.son2.apis.config.{Meta, RWTConfig}

abstract class Converter(val config: RWTConfig) {

  def convert(s: String): String

  def comment(content: String): String

  def metas: (Meta, Meta)

}
