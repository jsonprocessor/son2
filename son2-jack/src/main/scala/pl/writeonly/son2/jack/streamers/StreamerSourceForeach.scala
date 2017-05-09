package pl.writeonly.son2.jack.streamers

import java.io.PrintWriter

import pl.writeonly.son2.jack.liners.{Liner, LinerOpt}
import pl.writeonly.son2.jack.providers.Provider

import scala.io.Source

class StreamerSourceForeach(liner: Liner) extends StreamerSource(liner) {

  def this(provider: Provider) = this(new LinerOpt(provider))

  override def source2string(source: Source): String = {
    val sb = new StringBuilder()
    source.getLines().foreach { line =>
      appendLine(sb, line)
    }
    sb.toString()
  }

  override def source2pw(source: Source, pw: PrintWriter): Unit = {
    source.getLines().foreach { line =>
      appendLine(pw, line)
    }
  }
}