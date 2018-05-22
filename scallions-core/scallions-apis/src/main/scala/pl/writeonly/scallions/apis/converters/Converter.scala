package pl.writeonly.scallions.apis.converters

import pl.writeonly.scallions.apis.config.{Meta, RWTConfig}

abstract class Converter(val config: RWTConfig) {

  def convert(s: String): String

  def comment(content: String): String

  def metas: (Meta, Meta)

}
