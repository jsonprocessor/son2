package pl.writeonly.son2.core.notation

import pl.writeonly.son2.core.config.RWTConfig

trait PartialCreator extends PartialFunction[RWTConfig, NotationRWT] {

  override def apply(s: RWTConfig) = rwt(s)

  def rwt(c: RWTConfig) = NotationRWT(r(c), w(c), t(c))

  def r(c: RWTConfig): NotationReader

  def w(c: RWTConfig): NotationWriter

  def t(c: RWTConfig): NotationTranslator

  def is(s: RWTConfig): Boolean = isDefinedAt(s)

}
