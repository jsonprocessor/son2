package pl.writeonly.scallions.apis.notation

import pl.writeonly.scallions.apis.config.Meta

trait NotationMetaLike {
  def meta: Meta
}

class NotationMeta(val meta: Meta) extends NotationMetaLike
