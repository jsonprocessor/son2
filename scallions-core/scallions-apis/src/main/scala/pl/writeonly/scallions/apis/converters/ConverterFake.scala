package pl.writeonly.scallions.apis.converters

import pl.writeonly.scallions.apis.config.{Meta, RWTConfig}

class ConverterFake extends Converter(RWTConfig()) {
  override def convert(s: String): String = s

  override def comment(s: String): String = s

  override def metas = (Meta(null, null), Meta(null, null))

}
