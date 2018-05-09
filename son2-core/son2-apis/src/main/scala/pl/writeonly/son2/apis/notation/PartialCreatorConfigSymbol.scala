package pl.writeonly.son2.apis.notation

import pl.writeonly.son2.apis.pcreators.PCreatorConfig
import pl.writeonly.scalaops.pipe.Pipe

abstract class PartialCreatorConfigSymbol(f: Symbol)
    extends PCreatorConfig
    with Pipe {

  override def isDefinedAt(s: String): Boolean = s && format.name.startsWith(s)

  def format: Symbol = f

}
