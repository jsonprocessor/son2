package pl.writeonly.son2.apis.config

import com.fasterxml.jackson.annotation.JsonCreator

sealed trait RPath

case object Parse extends RPath

case object Json extends RPath

case class Read(path: String) extends RPath

object RPath {
  def parse: RPath = Parse

  def json: RPath = Json

  @JsonCreator
  def apply(path: String): RPath = Option(path).map(Read).getOrElse(Json)
}
