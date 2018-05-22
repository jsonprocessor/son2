package pl.writeonly.scallions.funs.streamers

import pl.writeonly.scallions.apis.converters.Converter
import pl.writeonly.scallions.funs.liners.{Liner, LinerOpt}

import scala.io.Source

class StreamerSourceForeach(liner: Liner) extends StreamerSource(liner) {

  def this(provider: Converter) = this(new LinerOpt(provider))

  override def source2pw(source: Source, pw: Appendable): Unit =
    source.getLines().foreach { line =>
      appendLine(pw, line)
    }

}
