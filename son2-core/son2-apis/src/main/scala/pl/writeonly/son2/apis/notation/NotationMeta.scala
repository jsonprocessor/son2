package pl.writeonly.son2.apis.notation

import pl.writeonly.son2.apis.config.MetaLike

trait NotationMetaLike {
  def meta: MetaLike
}

class NotationMeta(val meta: MetaLike) extends NotationMetaLike
