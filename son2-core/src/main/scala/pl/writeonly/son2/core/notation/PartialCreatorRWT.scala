package pl.writeonly.son2.core.notation

import pl.writeonly.son2.core.config.RWTConfig

trait PartialCreatorRWT extends PartialFunction[RWTConfig, NotationRWT] {

  override def apply(c: RWTConfig) = NotationRWT(r(c), w(c), t(c))

  def r(c: RWTConfig): NotationReader

  def w(c: RWTConfig): NotationWriter

  def t(c: RWTConfig): NotationTranslator

}
