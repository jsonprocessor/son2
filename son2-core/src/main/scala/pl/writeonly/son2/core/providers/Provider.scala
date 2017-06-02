package pl.writeonly.son2.core.providers

import pl.writeonly.son2.core.converters.Converter

class Provider(val converter : Converter) {

  def convert(s: String) = converter.apply(s)

  def comment(s: String) = s


}
