package pl.writeonly.son2.core.streamers

import java.io.PrintWriter

import pl.writeonly.son2.core.converters.Converter
import pl.writeonly.son2.core.liners.{Liner, LinerEither}

import scala.io.Source

class StreamerSourceAll(liner: Liner) extends StreamerSource(liner) {

  def this(provider: Converter) = this(new LinerEither(provider))

  override def source2string(source: Source): String = {
    val sb = new StringBuilder()
    val line = source.mkString
    appendLine(sb, line)
    sb.toString()
  }

  override def source2pw(source: Source, pw: PrintWriter): Unit = {
    val line = source.mkString
    appendLine(pw, line)
  }
}
