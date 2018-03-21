package pl.writeonly.son2.apis.converters

import pl.writeonly.son2.apis.config.RWTConfig

class ConverterFake extends Converter(RWTConfig()) {
  override def convert(s: String): String = s

  override def comment(s: String): String = s
}
