package pl.writeonly.scallions.funs.streamers

import pl.writeonly.scallions.apis.converters.Converter
import pl.writeonly.scallions.funs.liners.{Liner, LinerWithTry}
import pl.writeonly.scalaops.pipe.Pipe._

import scala.io.Source

class StreamerSourceAll(liner: Liner) extends StreamerSource(liner) {

  def this(provider: Converter) = this(new LinerWithTry(provider))

  override def source2pw(source: Source, pw: Appendable): Unit =
    source.mkString |> (appendLine(pw, _))
}
