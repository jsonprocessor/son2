package pl.writeonly.son2.liners

import pl.writeonly.son2.core.providers.Provider


abstract class Liner(val provider: Provider) {

  def convert(line: String) = provider.convert(line) + "\n"

  def comment(line: String) = provider.comment(line) + "\n"

  def apply(line: String): String

}
