package pl.writeonly.son2.core.converters

import pl.writeonly.son2.core.config.Config

class ConverterFake extends Converter(Config()) {
  override def convert(s: String): String = s

  override def comment(s: String): String = s
}
