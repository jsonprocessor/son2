package pl.writeonly.son2.core.notation

case class NotationPair(c: String => Config, r: NotationReader, w: NotationWriter)
