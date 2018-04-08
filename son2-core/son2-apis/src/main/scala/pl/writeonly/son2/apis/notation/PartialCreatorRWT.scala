package pl.writeonly.son2.apis.notation

import pl.writeonly.son2.apis.config.RWTConfig

trait PartialCreatorRWT extends PartialFunction[RWTConfig, NotationRWT] {

  override def apply(c: RWTConfig) = NotationRWT(r(c), w(c), t(c))

  def r(c: RWTConfig): NotationReaderLike

  def w(c: RWTConfig): NotationWriter

  def t(c: RWTConfig): NotationTranslator

}
