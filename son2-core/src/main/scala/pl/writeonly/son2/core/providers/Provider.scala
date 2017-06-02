package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.converters.ConverterImpl

class Provider(val converter : ConverterImpl) {

  def convert(s: String) = converter.apply(s)

  def comment(s: String) = s


}
