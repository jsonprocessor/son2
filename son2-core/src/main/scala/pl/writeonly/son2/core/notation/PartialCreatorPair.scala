package pl.writeonly.son2.core.notation


trait PartialCreatorPair extends PartialCreator {
  override def isDefinedAt(s: String) = s != null && format.name.startsWith(s)

  def format: Symbol

}
