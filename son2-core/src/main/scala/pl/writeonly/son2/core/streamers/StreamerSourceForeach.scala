package pl.writeonly.son2.core.streamers

import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.liners.{Liner, LinerOpt}

import scala.io.Source

class StreamerSourceForeach(liner: Liner) extends StreamerSource(liner) {

  def this(provider: Converter) = this(new LinerOpt(provider))

  override def source2pw(source: Source, pw: Appendable): Unit =
    source.getLines().foreach { line =>
      appendLine(pw, line)
    }

}
