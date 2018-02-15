package pl.writeonly.son2.core.notation

import pl.writeonly.son2.core.pcreators.PCreatorConfig

abstract class PartialCreatorConfigSymbol(f: Symbol) extends PCreatorConfig {

  override def isDefinedAt(s: String): Boolean =
    Option(s).isDefined && format.name.startsWith(s)

  def format: Symbol = f

}
