package pl.writeonly.son2.core.notation

import scala.util.control.Exception.catching

trait NotationReader extends PartialFunction[String, Any]{
  override def apply(s: String) : Any

  override def isDefinedAt(x: String) = catching(classOf[Exception])
    .opt(apply(x))
    .isDefined

}
