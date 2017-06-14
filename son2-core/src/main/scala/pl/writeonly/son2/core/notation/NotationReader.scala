package pl.writeonly.son2.core.notation

import scala.util.control.Exception.catching

trait NotationReader {
  def apply(s: String) : Any

  def isValid(s: String) : Boolean = catching(classOf[Exception])
    .opt(apply(s))
      .isDefined
}
