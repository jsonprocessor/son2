package pl.writeonly.son2.funs.streamers

import pl.writeonly.son2.apis.converters.Converter
import pl.writeonly.son2.funs.liners.{Liner, LinerWithTry}
import pl.writeonly.scalaops.pipe.Pipe._

import scala.io.Source

class StreamerSourceAll(liner: Liner) extends StreamerSource(liner) {

  def this(provider: Converter) = this(new LinerWithTry(provider))

  override def source2pw(source: Source, pw: Appendable): Unit =
    source.mkString |> (appendLine(pw, _))
}
