package pl.writeonly.son2.jack.liners

import pl.writeonly.son2.jack.providers.Provider
import pl.writeonly.son2.jack.util.AppLazyLogging


abstract class Liner(val provider: Provider) extends AppLazyLogging {

  def convert(line: String) = provider.convert(line) + "\n"

  def comment(line: String) = provider.comment(line) + "\n"

  def apply(line: String): String

}
