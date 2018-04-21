package pl.writeonly.son2.apis.config

import com.fasterxml.jackson.annotation.JsonCreator
import pl.writeonly.sons.utils.ops.Pipe._

object RPath {
  def parse: RPath = Parse

  def json: RPath = Json

  @JsonCreator
  def apply(path: String): RPath = path match {
    case s: String if s ? => Read(s)
    case _                => Json
  }

  sealed trait RPath

  case object Parse extends RPath

  case object Json extends RPath

  final case class Read(path: String) extends RPath

}
