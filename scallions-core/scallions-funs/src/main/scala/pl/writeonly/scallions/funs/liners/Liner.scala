package pl.writeonly.scallions.funs.liners

import pl.writeonly.scallions.apis.converters.Converter

abstract class Liner(val provider: Converter) {

  def convert(line: String): String = provider.convert(line) + "\n"

  def comment(line: String): String = provider.comment(line) + "\n"

  def apply(line: String): String

}
