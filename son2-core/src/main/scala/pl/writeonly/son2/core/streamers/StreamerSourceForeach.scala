package pl.writeonly.son2.core.streamers

import java.io.PrintWriter

import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.core.providers.{Provider, Provider2}

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