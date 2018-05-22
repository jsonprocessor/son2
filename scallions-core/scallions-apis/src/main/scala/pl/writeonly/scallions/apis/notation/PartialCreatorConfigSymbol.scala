package pl.writeonly.scallions.apis.notation

import pl.writeonly.scalaops.pipe.Pipe
import pl.writeonly.scallions.apis.chain.PCreatorConfig

abstract class PartialCreatorConfigSymbol(f: Symbol)
    extends PCreatorConfig
    with Pipe {

  override def isDefinedAt(s: String): Boolean = s && format.name.startsWith(s)

  def format: Symbol = f

}
