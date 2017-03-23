package pl.writeonly.son2.core.liners

import pl.writeonly.son2.core.providers.Provider
import pl.writeonly.son2.util.AppLogging


abstract class Liner(val provider : Provider) extends AppLogging {

  def convert(jsonString: String) = provider.convert(jsonString) + "\n"

  def comment(jsonString: String) = provider.comment(jsonString)  + "\n"

  def apply(jsonString:String) : String

}
