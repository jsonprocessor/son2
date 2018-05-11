package pl.writeonly.scallions.apis.notation

import pl.writeonly.scallions.apis.config.RWTConfig

trait PartialCreatorRWT extends PartialFunction[RWTConfig, NotationRWT] {

  override def apply(c: RWTConfig) = NotationRWT(r(c), w(c), t(c))

  def r(c: RWTConfig): NotationReaderLike

  def w(c: RWTConfig): NotationWriter

  def t(c: RWTConfig): NotationTranslator

}
