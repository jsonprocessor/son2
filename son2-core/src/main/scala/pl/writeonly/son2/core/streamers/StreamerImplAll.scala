package pl.writeonly.son2.core.streamers

import java.io.Writer
import java.util.stream.{Collectors, Stream}

import pl.writeonly.son2.core.liners.{Liner, LinerOpt}
import pl.writeonly.son2.core.providers.Provider
class StreamerImplAll(liner: Liner) extends StreamerImpl(liner) {

  def this(provider: Provider) = this(new LinerOpt(provider))

  override def stream2(stream : Stream[String], out: Writer): Unit = {
    val line = stream.collect(Collectors.joining())
    appendLine(out, line)
  }

}
