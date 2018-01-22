package pl.writeonly.son2.core.liners

import pl.writeonly.son2.core.converters.Converter

abstract class Liner(val provider: Converter) {

  def convert(line: String) = provider.convert(line) + "\n"

  def comment(line: String) = provider.comment(line) + "\n"

  def apply(line: String): String

}
