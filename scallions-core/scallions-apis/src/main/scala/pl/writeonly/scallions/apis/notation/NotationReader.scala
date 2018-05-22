package pl.writeonly.scallions.apis.notation

import pl.writeonly.scallions.apis.config.Meta

import scala.util.control.Exception.catching

trait NotationReaderLike
    extends NotationMetaLike
    with PartialFunction[String, Value] {
  //  override def toString() = MoreObjects.toStringHelper(this).toString

  override def apply(content: String): Value

  override def isDefinedAt(content: String): Boolean =
    catching(classOf[Exception])
      .opt(apply(content))
      .isDefined
}

abstract class NotationReader(meta: Meta)
    extends NotationMeta(meta)
    with NotationReaderLike
