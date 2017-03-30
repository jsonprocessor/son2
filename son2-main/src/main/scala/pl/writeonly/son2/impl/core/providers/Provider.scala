package pl.writeonly.son2.core.providers

import com.fasterxml.jackson.databind.ObjectMapper

import pl.writeonly.son2.core.Converter

class Provider(out:ObjectMapper) {
  val converter = new Converter(new ObjectMapper(), out, true)

  def convert(s: String) = converter.apply(s)

  def comment(s: String) = s
}
