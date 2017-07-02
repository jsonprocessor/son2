package pl.writeonly.son2.core.notation



trait PartialCreatorPair extends PartialCreator {
  override def isDefinedAt(s: String) = startsWith.name.startsWith(s)
  override def apply(v1: String) = NotationPair(r,w)


  def startsWith :Symbol
  def r : NotationReader
  def w: NotationWriter
}
