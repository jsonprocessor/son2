package pl.writeonly.son2.core.notation

import pl.writeonly.son2.core.config.Config


trait PartialCreatorPair extends PartialCreator {
  override def isDefinedAt(s: String) = s != null && format.name.startsWith(s)

  def format: Symbol

}
