package pl.writeonly.son2.apis.notation

import pl.writeonly.son2.apis.config.Meta

trait NotationMetaLike {
  def meta: Meta
}

class NotationMeta(val meta: Meta) extends NotationMetaLike
