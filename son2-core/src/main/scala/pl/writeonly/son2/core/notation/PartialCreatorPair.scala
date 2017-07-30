package pl.writeonly.son2.core.notation

import pl.writeonly.son2.core.config.Config


trait PartialCreatorPair extends PartialCreator {
  override def isDefinedAt(s: String) = s != null && format.name.startsWith(s)

  override def apply(v1: String) = NotationPair(c, r, w)

  def format: Symbol

  def c: String => Config

  def r: NotationReader

  def w: NotationWriter
}
