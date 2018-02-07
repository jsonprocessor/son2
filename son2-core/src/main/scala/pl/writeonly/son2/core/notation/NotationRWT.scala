package pl.writeonly.son2.core.notation

case class NotationRWT(
  r: NotationReader = null,
  w: NotationWriter = null,
  t: NotationTranslator = null) {}
