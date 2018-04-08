package pl.writeonly.son2.apis.notation

import pl.writeonly.son2.apis.config.MetaLike

import scala.util.control.Exception.catching

trait NotationReaderLike
    extends NotationMetaLike
    with PartialFunction[String, Any] {
  //  override def toString() = MoreObjects.toStringHelper(this).toString

  override def apply(content: String): Any

  override def isDefinedAt(content: String): Boolean =
    catching(classOf[Exception])
      .opt(apply(content))
      .isDefined
}

abstract class NotationReader(meta: MetaLike)
    extends NotationMeta(meta)
    with NotationReaderLike
