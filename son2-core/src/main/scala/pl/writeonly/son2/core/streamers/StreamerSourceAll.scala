package pl.writeonly.son2.core.streamers

import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.liners.{Liner, LinerEither}
import pl.writeonly.sons.utils.ops.Pipe._

import scala.io.Source

class StreamerSourceAll(liner: Liner) extends StreamerSource(liner) {

  def this(provider: Converter) = this(new LinerEither(provider))

  override def source2pw(source: Source, pw: Appendable): Unit =
    source.mkString |> (appendLine(pw, _))
}
