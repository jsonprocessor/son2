package pl.writeonly.son2.apis.notation

import pl.writeonly.son2.apis.pcreators.PCreatorConfig
import pl.writeonly.addons.pipe.Pipe._

abstract class PartialCreatorConfigSymbol(f: Symbol) extends PCreatorConfig {

  override def isDefinedAt(s: String): Boolean = s && format.name.startsWith(s)

  def format: Symbol = f

}
